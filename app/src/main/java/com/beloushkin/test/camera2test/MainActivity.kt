package com.beloushkin.test.camera2test

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.beloushkin.test.camera2test.fragments.PreviewFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val drawerToggle by lazy {
        ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
        navigationView.setNavigationItemSelectedListener {
            selectDrawerItem(it)
            true
        }

        val fragment = PreviewFragment.newInstance()
        addFragment(fragment)

        // The viewpager will be implemented once it's fragments have been implemented
        // val pagerAdapter = CamFragmentPagerAdapter(supportFragmentManager)
        // viewPager.adapter = pagerAdapter
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        drawerToggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        drawerToggle.onConfigurationChanged(newConfig)
    }

    private fun selectDrawerItem(item: MenuItem) {
        val fragment: Fragment? = null

        //val fragmentClass = TODO("Will be implemented later")
        drawerLayout.closeDrawer(GravityCompat.START)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (drawerToggle.onOptionsItemSelected(item)) true else super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.fragment_menu, menu)
        return false
    }

    private fun addFragment(fragment: Fragment) {
        val fragmentTransaction =  supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }

    fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager?.beginTransaction()
        fragmentTransaction?.apply {
            replace(R.id.fragmentContainer, fragment)
            addToBackStack(null)
            commit()
        }
    }
}
