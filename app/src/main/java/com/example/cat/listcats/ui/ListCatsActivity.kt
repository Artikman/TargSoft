package com.example.cat.listcats.ui

import android.Manifest
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import com.example.cat.R
import com.example.cat.data.source.local.DBHelper
import com.example.cat.listcats.viewmodel.ListCatsViewModel
import com.example.cat.listcats.viewmodel.ListCatsViewModelFactory
import com.example.cat.util.NetworkConnectivity
import com.example.cat.util.Utils
import com.yuyakaido.android.cardstackview.*
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_list_cat.*
import kotlinx.android.synthetic.main.item_cat.*
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import javax.inject.Inject

class ListCatsActivity : AppCompatActivity(), CardStackListener {

    @Inject
    lateinit var viewModelFactory: ListCatsViewModelFactory
    private lateinit var viewModel: ListCatsViewModel
    private var imageView: ImageView? = null
    private var btnSave: ImageView? = null
    private var btnFavourite: ImageView? = null

    private val cardStackView by lazy { card_stack_view }
    private val manager by lazy { CardStackLayoutManager(this, this) }
    private val adapter by lazy { CatsAdapter() }

    private var currentPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_cat)

        ActivityCompat.requestPermissions(
            this@ListCatsActivity,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            1
        )

        imageView =
            findViewById<View>(R.id.item_image) as? ImageView
        btnSave = findViewById(R.id.btn_floopy)
        btnFavourite = findViewById(R.id.btn_favourite)
        btnSave?.setOnClickListener { imagesavetomyphonegallery() }
        btnFavourite?.setOnClickListener {
            val bitmap = (item_image.drawable as BitmapDrawable).bitmap

            DBHelper(applicationContext)
                .addBitmap(Utils.getBytes(bitmap))
            Toast.makeText(this@ListCatsActivity, "Save success!", Toast.LENGTH_SHORT).show()
        }

        AndroidInjection.inject(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(ListCatsViewModel::class.java)

        initViews()

    }

    private fun imagesavetomyphonegallery() {
        val img =
            findViewById<ImageView>(R.id.item_image)
        val draw = img.drawable as BitmapDrawable
        val bitmap = draw.bitmap
        var outputStream: FileOutputStream? = null
        val sdCard = Environment.getExternalStorageDirectory()
        val dir = File(sdCard.absolutePath + "/SaveImage")
        dir.mkdir()
        val fileName =
            String.format("%d.jpg", System.currentTimeMillis())
        val outFile = File(dir, fileName)
        try {
            outputStream = FileOutputStream(outFile)
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
        try {
            outputStream!!.flush()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        try {
            outputStream!!.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }


    private fun initViews() {

        if (NetworkConnectivity(this).isConnected()) {
            viewModel.handleEvent(ListCatEvent.OnStart)
        } else {
            Toast.makeText(this, "Check your network connection and retry", Toast.LENGTH_SHORT).show()

        }
        observeViewModel()
        setupCardStackView()
        setupButtons()
    }

    private fun observeViewModel() {
        viewModel.catsList.observe(
            this,
            Observer { catImageList ->
                adapter.setCatslist(catImageList)
            }
        )
    }

    private fun setupCardStackView() {
        manager.setStackFrom(StackFrom.None)
        manager.setVisibleCount(3)
        manager.setTranslationInterval(8.0f)
        manager.setScaleInterval(0.95f)
        manager.setSwipeThreshold(0.3f)
        manager.setMaxDegree(20.0f)
        manager.setDirections(Direction.HORIZONTAL)
        manager.setCanScrollHorizontal(true)
        manager.setCanScrollVertical(true)
        manager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
        manager.setOverlayInterpolator(LinearInterpolator())
        cardStackView.layoutManager = manager
        cardStackView.adapter = adapter
        cardStackView.itemAnimator.apply {
            if (this is DefaultItemAnimator) {
                supportsChangeAnimations = false
            }
        }
    }

    private fun setupButtons() {
        setupLikeButton()
        setupUnLikeButton()
        setupUnWindButton()
    }

    private fun setupLikeButton() {
        bt_like.setOnClickListener {
            val setting = SwipeAnimationSetting.Builder()
                .setDirection(Direction.Right)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(AccelerateInterpolator())
                .build()
            manager.setSwipeAnimationSetting(setting)
            cardStackView.swipe()
        }
    }

    private fun setupUnLikeButton() {
        bt_un_like.setOnClickListener {
            val setting = SwipeAnimationSetting.Builder()
                .setDirection(Direction.Left)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(AccelerateInterpolator())
                .build()
            manager.setSwipeAnimationSetting(setting)
            cardStackView.swipe()
        }
    }

    private fun setupUnWindButton() {
        bt_rewind.setOnClickListener {
            val setting = RewindAnimationSetting.Builder()
                .setDirection(Direction.Bottom)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(DecelerateInterpolator())
                .build()
            manager.setRewindAnimationSetting(setting)
            cardStackView.rewind()
        }
    }

    override fun onCardDisappeared(view: View?, position: Int) {
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {
    }

    override fun onCardSwiped(direction: Direction?) {
        viewModel.handleEvent(ListCatEvent.OnSwipe(currentPosition, direction))
        Log.d("swiped", "$currentPosition $direction")
    }

    override fun onCardCanceled() {
    }

    override fun onCardAppeared(view: View?, position: Int) {
        currentPosition = position
    }

    override fun onCardRewound() {
    }
}