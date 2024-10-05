package com.example.cartevisite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // Pour gérer l'espacement
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cartevisite.ui.theme.CarteVisiteTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarteVisiteTheme {
                BusinessCardScreen()
            }
        }
    }
}

@Composable
fun BusinessCardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween // Cela permet de répartir l'espace verticalement
    ) {
        // Spacer pour centrer l'image et le texte au milieu de l'écran
        Spacer(modifier = Modifier.weight(1f))

        // Image au centre (Logo Android)
        Box(
            modifier = Modifier
                .size(120.dp) // Taille de la Box, ajustée selon vos besoins
                .background(Color.Black), // Arrière-plan noir
            contentAlignment = Alignment.Center // Centre l'image dans le Box
        ) {
            // Image en haut (Logo Android)
            Image(
                painter = painterResource(id = R.drawable.android_logo), // Remplacez par votre image
                contentDescription = stringResource(id = R.string.android_logo_desc),
                modifier = Modifier
                    .size(100.dp), // Taille de l'image
                contentScale = ContentScale.Fit
            )
        }

        // Nom de l'utilisateur
        Text(
            text = "Aya Hichri",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp)
        )

        // Poste de l'utilisateur
        Text(
            text = "Etudiante en dev informatique",
            color = Color.Green,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
        )

        // Spacer pour ajuster l'espace entre le texte et les informations de contact
        Spacer(modifier = Modifier.weight(1f))

        // Informations de contact centrées
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Centrage horizontal des icônes et du texte
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            ContactInfoRow(icon = Icons.Filled.Phone, info = "    +116 50 99 11 72         ")
            ContactInfoRow(icon = Icons.Filled.Share, info = "       @AndroidDev              ")
            ContactInfoRow(icon = Icons.Filled.Email, info = "ayahichri2022@gmail.com")
        }
    }
}

@Composable
fun ContactInfoRow(icon: androidx.compose.ui.graphics.vector.ImageVector, info: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically, // Aligner les éléments verticalement
        horizontalArrangement = Arrangement.Center, // Centrer horizontalement les éléments dans la Row
        modifier = Modifier
            .fillMaxWidth() // S'assurer que la Row occupe toute la largeur
            .padding(vertical = 4.dp) // Ajouter un padding uniforme verticalement
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp), // Taille uniforme pour toutes les icônes
            tint = Color.Green
        )
        Spacer(modifier = Modifier.width(16.dp)) // Espacement entre l'icône et le texte
        Text(
            text = info,
            fontSize = 16.sp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun BusinessCardScreenPreview() {
    CarteVisiteTheme {
        BusinessCardScreen()
    }
}
