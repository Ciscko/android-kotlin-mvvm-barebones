package com.example.mqpos

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier

import com.example.mqpos.ui.theme.MQPOSTheme
import com.example.mqpos.view.composables.SearchTodo
import com.example.mqpos.view.composables.TodoList
import com.example.mqpos.view.composables.TodoPageTitle
import com.example.mqpos.view.composables.todos
import com.example.qkpos.view_model.viewmodels.MainViewModel
import com.example.qkpos.view_model.viewmodels.MainViewModelFactory

import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class MainActivity : ComponentActivity(), KodeinAware {

    //override val kodein by lazy { (application as MainApplication).kodein }

    override val kodein by org.kodein.di.android.kodein()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val facto : MainViewModelFactory by instance()
        val mainVM : MainViewModel by viewModels { facto }

        setContent {
            MQPOSTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Main(mainVM  = mainVM)
                }
            }
        }
    }
}

@Composable
fun Main(mainVM : MainViewModel ){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TodoPageTitle(title = "TODOs 2023")
        SearchTodo(onChange =  { textValue -> { Log.i("Value added", textValue)} })
        TodoList(allTodos = todos())
    }

}

