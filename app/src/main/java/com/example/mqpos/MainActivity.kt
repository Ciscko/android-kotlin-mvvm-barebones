package com.example.mqpos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.mqpos.ui.theme.MQPOSTheme
import com.example.qkpos.model.data.db.MainDataBase
import com.example.qkpos.model.repositories.MainRepositoryImplementation
import com.example.qkpos.view_model.viewmodels.MainViewModel
import com.example.qkpos.view_model.viewmodels.MainViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = MainDataBase(context = this)
        val repo = MainRepositoryImplementation(db = db)
        val facto = MainViewModelFactory(repo)
        //val mainVM = ViewModelProvider(this, facto).get(MainViewModel::class.java)
        val mainVM : MainViewModel by viewModels { facto }


        setContent {
            MQPOSTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Techs(mainVM  = mainVM )
                }
            }
        }
    }
}

@Composable
fun Techs(mainVM : MainViewModel ){
    var hopes = mainVM.greeting.observeAsState(listOf())
    Text(hopes.value.toString())
}
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MQPOSTheme {
        Greeting("Android")
    }
}