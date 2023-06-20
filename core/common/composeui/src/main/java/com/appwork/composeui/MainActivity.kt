package com.appwork.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appwork.composeapp.ui.composeviewext.fullScreenView
import com.appwork.composeapp.ui.composeviewext.toTransparentView
import com.appwork.composeapp.ui.theme.ComposeAppTheme

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ComposeAppTheme {
        // A surface container using the 'background' color from the theme
        PhoneNumberView()
        //FIXME make this layout scrollable and handle keyboard states
        // Add viewmodel and coroutines
        // Create a VM and State class as well
        // Communication should be like Event i.e. some stream -> Event Emit -> EventHandler class
        // for updating the state -> Update the UI.
      }
    }
  }
}

@Composable
fun PhoneNumberView(modifier: Modifier = Modifier) {
  Surface(
    modifier = modifier.background(Color.White),
  ) {
    Column(
      modifier = modifier.fullScreenView()
    ) {
      var phoneNumber by remember { mutableStateOf("") }
      val phoneNumberHeaderBgd = R.drawable.ic_launcher_background
      val headerImageDesc = R.string.str_cd_phone_number_header
      val headerText = stringResource(R.string.str_app_header)
      PhoneNumberHeader(modifier, phoneNumberHeaderBgd, headerImageDesc)
      HeaderContent(modifier, headerText)
      LoginInputContainerView(modifier, stringResource(R.string.str_continue), phoneNumber)
      BottomLayoutView(modifier)
    }
  }
}

@Composable
fun PhoneNumberHeader(
  modifier: Modifier,
  @DrawableRes background: Int,
  @StringRes headerImageDesc: Int,
) {

  Image(
    contentScale = ContentScale.Fit,
    modifier = modifier
      .aspectRatio(1f)
      .fillMaxWidth(),
    painter = painterResource(id = background),
    contentDescription = stringResource(headerImageDesc),
  )
}

@Composable
fun HeaderContent(modifier: Modifier, headerText: String) {
  val paddingHorizontal = 16.dp
  val paddingVertical = 8.dp
  Text(
    modifier = modifier
      .padding(
        vertical = paddingVertical,
        horizontal = paddingHorizontal
      )
      .fillMaxWidth(),
    text = headerText,
    style = TextStyle(
      color = Color.Black,
      fontWeight = FontWeight.Bold,
      fontSize = 24.sp
    ),
    textAlign = TextAlign.Center
  )
}

@Composable
fun LoginInputContainerView(
  modifier: Modifier,
  continueText: String,
  phoneNumber: String
) {
  Column(
    modifier = modifier
      .padding(top = 32.dp)
      .padding(horizontal = 16.dp),
  ) {
    LoginInfo(modifier, stringResource(R.string.str_login_sign_up))
    LoginInputView(modifier = modifier, phoneNumber)
    ContinueButton(modifier = modifier, text = continueText, phoneNumber)
    Divider(color = Color.Gray, modifier = modifier.padding(vertical = 32.dp))
  }
}

@Composable
fun LoginInfo(modifier: Modifier, text: String) {
  Row(
    modifier = modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Divider(color = Color.Gray, modifier = modifier.weight(1.50f))
    Text(
      modifier = modifier.weight(1.0f),
      text = text,
      color = Color.Gray,
      maxLines = 1,
      textAlign = TextAlign.Center,
      fontSize = 11.sp,
    )
    Divider(color = Color.Gray, modifier = modifier.weight(1.50f))
  }
}

@Composable
fun LoginInputView(modifier: Modifier = Modifier, phoneNumber: String) {
  Surface(
    modifier = Modifier
      .padding(top = 16.dp)
      .fillMaxWidth(),
    shape = RoundedCornerShape(8.dp),
    border = BorderStroke(1.dp, color = Color.LightGray),
    elevation = 1.dp,
  ) {
    Row(
      modifier = modifier
        .fillMaxWidth()
        .padding(2.dp),
      verticalAlignment = Alignment.CenterVertically,
    ) {
      CountryCodeView(
        modifier = modifier,
        countryCodeValue = stringResource(id = R.string.str_country_code)
      )
      PhoneNumberField(
        modifier = modifier,
        phoneNumber = phoneNumber,
        label = stringResource(id = R.string.str_enter_phone_number)
      )
    }
  }
}

@Composable
fun CountryCodeView(
  modifier: Modifier = Modifier,
  countryCodeValue: String,
) {
  Text(
    modifier = modifier.padding(start = 16.dp),
    text = countryCodeValue,
    color = Color.Black,
    textAlign = TextAlign.Center,
    fontSize = 13.sp,
  )
}

@Composable
fun PhoneNumberField(
  phoneNumber: String,
  modifier: Modifier,
  label: String,
) {
  var input = phoneNumber
  TextField(
    value = phoneNumber,
    onValueChange = { input = it },
    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    label = { Text(label) },
    modifier = modifier,
    colors = TextFieldDefaults.toTransparentView(),
  )
}

@Composable
fun ContinueButton(
  modifier: Modifier,
  text: String,
  phoneNumber: String,
) {
  val isEnable = phoneNumber.length >= 10
  Button(
    modifier = modifier
      .fillMaxWidth()
      .padding(top = 16.dp)
      .size(52.dp),
    shape = RoundedCornerShape(8.dp),
    onClick = { },
    enabled = isEnable,
  ) {
    Text(text = text)
  }
}

@Composable
fun BottomLayoutView(modifier: Modifier) {
  val privacyPolicy = stringResource(id = R.string.str_privacy_policy)
  val strAmp = stringResource(id = R.string.str_amp)
  val termsOfService = stringResource(id = R.string.str_terms_of_services)
  Row(
    modifier = modifier
      .fillMaxWidth()
      .fillMaxHeight(),
    verticalAlignment = Alignment.Bottom,
    horizontalArrangement = Arrangement.Center,
  ) {
    RenderText(
      modifier = modifier,
      text = termsOfService,
      textColor = Color.Blue,
      fontStyle = FontStyle.Italic
    )
    RenderText(
      modifier = modifier,
      text = strAmp,
      textColor = Color.Black,
    )
    RenderText(
      modifier = modifier,
      text = privacyPolicy,
      textColor = Color.Blue,
      fontStyle = FontStyle.Italic
    )
  }
}

@Composable
fun RenderText(
  modifier: Modifier,
  text: String,
  textColor: Color,
  fontStyle: FontStyle = FontStyle.Normal,
) {
  Text(
    modifier = modifier
      .padding(vertical = 8.dp)
      .padding(horizontal = 4.dp),
    text = text,
    textAlign = TextAlign.Center,
    color = textColor,
    fontStyle = fontStyle,
  )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  ComposeAppTheme {
    PhoneNumberView()
  }
}