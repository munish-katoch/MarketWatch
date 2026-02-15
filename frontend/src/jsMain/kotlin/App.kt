import androidx.compose.runtime.*
import org.jetbrains.compose.web.dom.*
import kotlinx.browser.window
import kotlinx.coroutines.*

@Composable
fun App() {

    var symbol by remember { mutableStateOf("AAPL") }
    var result by remember { mutableStateOf("No data") }

    val scope = rememberCoroutineScope()

    Div {
        H2 { Text("Stock Dashboard") }

        Input(value = symbol) {
            onInput { symbol = it.value }
        }

        Button(attrs = {
            onClick {
                scope.launch {
                    val response = window
                        .fetch("http://localhost:8080/api/stock?symbol=$symbol")
                        .await()
                        .text()
                        .await()

                    result = response
                }
            }
        }) {
            Text("Fetch Stock")
        }

        Pre {
            Text(result)
        }
    }
}