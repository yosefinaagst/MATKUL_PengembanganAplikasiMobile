package com.example.ui_profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Whatsapp
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun Profile(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F8F8))
            .verticalScroll(rememberScrollState())

    ) {
        ProfileHeader()

        ProfileIdentity()

        StudyCard()

        Spacer(modifier = Modifier.height(24.dp))

        StudentInformationCard()

        Spacer(modifier = Modifier.height(24.dp))

        SocialMediaCard()

        Spacer(modifier = Modifier.height(32.dp))

    }
}

@Composable
fun ProfileHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
    ) {

        Image(
            painter = painterResource(R.drawable.profile),
            contentDescription = "Profile Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ProfileIdentity() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = (-55).dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.background),
            contentDescription = "Foto Profile",
            modifier = Modifier
                .size(110.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Yosefina Agustine K. Ofong",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "245150400111030",
            fontSize = 14.sp,
            color = Color.DarkGray
        )
    }
}

@Composable
fun StudyCard() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(18.dp),
        color = Color.White,
        shadowElevation = 1.dp
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = "Program Studi",
                    fontSize = 13.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Sistem Informasi",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Box(
                modifier = Modifier
                    .width(1.dp)
                    .height(35.dp)
                    .background(Color.LightGray)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 24.dp)
            ) {

                Text(
                    text = "Fakultas",
                    fontSize = 13.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Ilmu Komputer",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
fun StudentInformationCard() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(18.dp),
        color = Color.White,
        shadowElevation = 1.dp
    ) {

        Column(
            modifier = Modifier.padding(
                horizontal = 18.dp,
                vertical = 14.dp
            )
        ) {

            InformationRow(
                icon = Icons.Default.School,
                title = "Universitas",
                value = "Brawijaya"
            )

            Divider(color = Color(0xFFE5E5E5))

            InformationRow(
                icon = Icons.Default.CheckCircle,
                title = "Status",
                value = "Mahasiswa Aktif"
            )

            Divider(color = Color(0xFFE5E5E5))

            InformationRow(
                icon = Icons.Default.AccountCircle,
                title = "Semester",
                value = "5"
            )

            Divider(color = Color(0xFFE5E5E5))

            InformationRow(
                icon = Icons.Default.CalendarMonth,
                title = "Tahun Masuk",
                value = "2024"
            )

            Divider(color = Color(0xFFE5E5E5))

        }
    }
}

@Composable
fun InformationRow(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    value: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = icon,
            contentDescription = title,
            modifier = Modifier.size(23.dp),
            tint = Color.Black
        )

        Spacer(modifier = Modifier.width(14.dp))

        Text(
            text = title,
            modifier = Modifier.weight(1f),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )

        Text(
            text = value,
            fontSize = 14.sp
        )
    }
}

@Composable
fun SocialMediaCard() {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(18.dp),
        color = Color.White,
        shadowElevation = 2.dp
    ) {

        Column(
            modifier = Modifier.padding(18.dp)
        ) {

            Text(
                text = "Media Sosial",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                SocialMediaButton(
                    icon = Icons.Default.Person,
                    url = "https://www.instagram.com/titinnnpjm_"
                )

                SocialMediaButton(
                    icon = Icons.Default.Person,
                    url = "https://www.linkedin.com/in/yosefinaagustine"
                )

                SocialMediaButton(
                    icon = Icons.Default.Code,
                    url = "https://github.com/yosefinaagust"
                )

                SocialMediaButton(
                    icon = Icons.Default.Whatsapp,
                    url = "https://wa.me/6281338377658"
                )
            }
        }
    }
}

@Composable
fun SocialMediaButton(
    icon: ImageVector,
    url: String
) {
    val uriHandler = LocalUriHandler.current

    Box(
        modifier = Modifier
            .size(52.dp)
            .clip(CircleShape)
            .background(Color(0xFFD1C1D1))
            .clickable {
                uriHandler.openUri(url)
            },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(26.dp),
            tint = Color(0xFF745D74)
        )
    }
}
