package com.example.mqpos.view.composables

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mqpos.model.data_classes.Todo
import com.example.mqpos.ui.theme.MQPOSTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.text.font.FontWeight
import java.util.logging.Level.INFO

fun todos() : List<Todo> {
    var allTodos = mutableListOf<Todo>()
    for(i in 1..20){
        var todo = Todo(
            title = "Todo Number ${i}",
            percentage_done = if(i % 2 == 0) 20.0f else 30.0f,
            start_date = "2nd Jan 2023",
            expected_completion_date = "20th Feb 2023",
            id = null
        )
        allTodos.add(todo)
    }
    return allTodos.toList()
}

@Composable
fun TodoList(allTodos : List<Todo>){
        LazyColumn( modifier = Modifier.fillMaxSize()){
            items(items = allTodos, itemContent = { todoItem ->
                TodoItem(todo = todoItem )
            })
        }
}

@Composable
fun TodoItem(todo : Todo){
    Row(modifier = Modifier.padding(4.dp)) {
        Card(
            elevation = 8.dp,
            shape = RoundedCornerShape(5.dp),
            contentColor = Color.Blue
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp, vertical = 12.dp)
            ) {
                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(todo.title)
                        Text("Done: ${todo.percentage_done}%", color = Color.Gray)
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Start: ${todo.start_date}", color = Color.Gray, fontSize = 10.sp)
                        Text("End: ${todo.expected_completion_date}", color = Color.Red, fontSize = 10.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun TodoPageTitle(title : String){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Text(title, fontWeight = FontWeight.ExtraBold, fontSize = 24.sp)
        Text(text = "So help me God.", fontSize = 10.sp, color = Color.Magenta)
    }
}

@Composable
fun SearchTodo(onChange : (text : String) -> Unit){
    var searchText = rememberSaveable {
        mutableStateOf("")
    }
    val change = { text : String -> searchText.value = text; onChange(text) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ){
        OutlinedTextField(
            value = searchText.value,
            onValueChange = {change(it)},
            label = { Text("Search Todo ")},
            placeholder = { Text("Type to search")} ,
            leadingIcon = { Icon(
                Icons.Outlined.Search,
                contentDescription = " ",
                tint = Color.Gray
            )  } ,
            modifier = Modifier.fillMaxWidth()
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MQPOSTheme {
        SearchTodo(onChange =  { textValue -> { Log.i("Value added", textValue)} })
    }
}