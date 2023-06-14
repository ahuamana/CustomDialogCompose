package com.paparazziteam.dialogcustomcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.paparazziteam.dialogcustomcompose.ui.theme.DialogCustomComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DialogCustomComposeTheme {
                // A surface container using the 'background' color from the theme

            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DialogCustomComposeTheme {

        CustomDialog(
            onDismissRequest = { /*TODO*/ }
        )
    }
}

@Composable
fun HomeScreen(){
    val showDialog = remember { mutableStateOf(false) }

    if(showDialog.value){
        CustomDialog(
            onDismissRequest = { showDialog.value = false }
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            showDialog.value = true
        }) {
            Text(text = "Show Dialog")
        }
    }

}

@Preview
@Composable
fun HomeScreenPrev() {
    HomeScreen()
}




@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomDialog(
    onDismissRequest: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
        )
    ) {
        Box() {
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 65.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)) {
                Column(
                    modifier = Modifier
                        .padding(top = 70.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Successfully",
                        fontWeight = FontWeight.Bold,
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = "Your account has been created successfully",
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                    Button(onClick = { onDismissRequest() }) {
                        Text(text = "Regresar")
                    }
                    Spacer(modifier = Modifier.size(16.dp))
                }

            }

            Image(
                painter = painterResource(id = R.drawable.ic_check),
                contentDescription = "Check",
                modifier = Modifier.align(alignment = Alignment.TopCenter)
            )
        }

    }
}