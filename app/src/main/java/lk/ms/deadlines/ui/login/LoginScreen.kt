package lk.ms.deadlines.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lk.ms.deadlines.R


@Composable
fun LoginPage() {
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
    ) {
        // Logo container with fixed height
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp) // Fixed height for logo container
        ) {
            Image(
                painter = painterResource(R.drawable.frame_16),
                contentDescription = "App Logo",
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(180.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        TextBox(
            text = "Email/UserName",
            username
        ) {
            username = it
        }
        Spacer(modifier = Modifier.height(10.dp))
        TextBox(
            text = "Password",
            password
        ) {
            password = it
        }
        Spacer(modifier = Modifier.height(20.dp))

        // Login buttons

        LoginScreenButton(
            text = "Login",
            onClick = { /* Handle login click */ },
        )
        Spacer(modifier = Modifier.height(10.dp))
        LoginScreenButton(
            text = "Continue with Google",
            onClick = { /* Handle Google login click */ },
        )
        Spacer(modifier = Modifier.height(10.dp))
        LoginScreenButton(
            text = "Create Account",
            onClick = { /* Handle create account click */ },
        )


    }
}

/**
 * TextBox is a reusable text input component for the login screen.
 * It takes a label text, a value, and an onTextChange function as parameters.
 */
@Composable
fun TextBox(
    text: String,
    value: String,
    onTextChange: (String) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        TextField(
            value = value,
            onValueChange = onTextChange,
            label = { Text(text) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.8f),
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 25.dp,
                bottomEnd = 25.dp,
                bottomStart = 25.dp
            ),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color(0xFF6A8AEF),
                unfocusedIndicatorColor = Color(0xFF5577DD),
                focusedContainerColor = Color(0xFF778AEE),
                unfocusedContainerColor = Color(0xFF6683E5),
                focusedTextColor = Color(0xFFEEF2FF),
                unfocusedTextColor = Color(0xFFD8E0FF),
                cursorColor = Color(0xFFFF6FA9),
                disabledIndicatorColor = Color(0xFFB088FF),
                disabledContainerColor = Color(0xFFCEB6FF),
                disabledTextColor = Color(0xFF9F7CE3)
            ),
            textStyle = LocalTextStyle.current.copy(fontSize = 18.sp) // Set your desired text size here
        )
    }
}



/**
 * LoginScreenButton is a reusable button component for the login screen.
 * It takes a text label and an onClick function as parameters.
 */
@Composable
fun LoginScreenButton(
    text: String,
    onClick: () -> Unit, // Takes no parameters and returns nothing
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick, // OnClick is executed
        modifier = modifier
            .fillMaxWidth(0.8f)
            .height(52.dp),
        shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 25.dp,
                    bottomStart = 25.dp,
                    bottomEnd = 25.dp
                ),
        colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE4E4E4),
                    contentColor = Color.Black
                ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 20.dp,
            pressedElevation = 12.dp
        )
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = text,
                fontSize = 18.sp,
                textAlign = TextAlign.Left,
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    LoginPage()
}