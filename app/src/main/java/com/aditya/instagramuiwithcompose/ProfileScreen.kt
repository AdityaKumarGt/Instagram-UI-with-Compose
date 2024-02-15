package com.aditya.instagramuiwithcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun Preview() {
    Surface {
        ProfileScreen()
    }
}


//Code for the Profile Screen
@Composable
fun ProfileScreen() {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {


        TopBar(
            name = "stellar_aditya_404",
            modifier = Modifier
                .padding(10.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            ProfileSection()
            Spacer(modifier = Modifier.height(25.dp))
            ButtonSection(modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(25.dp))

            HighlightSection(
                highlights = listOf(
                    ImageWithText(
                        image = painterResource(id = R.drawable.programming),
                        text = "Programming"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.photography),
                        text = "Photography"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.nature),
                        text = "Nature"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.brothers),
                        text = "Brothers"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.aditya_image),
                        text = "Me"
                    ),
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            PostTabView(
                imageWithTexts = listOf(
                    ImageWithText(
                        image = painterResource(id = R.drawable.ic_grid),
                        text = "Posts"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.ic_reels),
                        text = "Reels"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.baseline_bookmark_border_24),
                        text = "Bookmark"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.profile),
                        text = "Profile"
                    ),
                )
            ) {
                selectedTabIndex = it
            }

            when (selectedTabIndex) {
                0 -> PostSection(
                    posts = listOf(
                        painterResource(id = R.drawable.android2),
                        painterResource(id = R.drawable.kotlin),
                        painterResource(id = R.drawable.flowers),
                        painterResource(id = R.drawable.java),
                        painterResource(id = R.drawable.clean_architecture),
                        painterResource(id = R.drawable.mvvm),
                        painterResource(id = R.drawable.android),
                        painterResource(id = R.drawable.brothers_post),
                        painterResource(id = R.drawable.programmer),
                        painterResource(id = R.drawable.mountains),
                    ),
                    modifier = Modifier.fillMaxWidth()
                )


                1 -> ReelsSection(
                    reels = listOf(
                        ImageWithText(painterResource(id = R.drawable.reel_image1), "33.2K"),
                        ImageWithText(painterResource(id = R.drawable.reel_image2), "1.3M"),
                        ImageWithText(painterResource(id = R.drawable.reel_image3), "11.8K"),
                        ImageWithText(painterResource(id = R.drawable.reel_image4), "99K"),
                        ImageWithText(painterResource(id = R.drawable.reel_image5), "872K"),
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                2 ->  Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No bookmarks available!",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(10.dp)
                    )
                }

                3 -> PostSection(
                    posts = listOf(
                        painterResource(id = R.drawable.android),
                        painterResource(id = R.drawable.brothers_post),
                    ),
                    modifier = Modifier.fillMaxWidth()
                )



            }

        }
    }
}

@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "Bell",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = "Dot menu",
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )
    }
}


@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            RoundImage(
                image = painterResource(id = R.drawable.aditya_image),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7f))
        }


        ProfileDescription(
            displayName = "Android App Developer",
            description = "I will turn your ideas into an app. Send me an email!\uD83D\uDCE7\n" +
                    "| Java | Kotlin | Jetpack Compose | Clean code | MVVM | SOLID |",
            url = "https://github.com/AdityaKumarGt",
            followedBy = listOf("mr._raja114", "codewithaditya001"),
            otherCount = 6
        )
    }
}


@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)

    )
}


@Composable
fun StatSection(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStat(numberText = "92", text = "Posts")
        ProfileStat(numberText = "11.4K", text = "Followers")
        ProfileStat(numberText = "63", text = "Following")

    }

}


@Composable
fun ProfileStat(
    numberText: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)
    }
}


@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = url,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        if (followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed by ")
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1) {
                            append(", ")
                        }
                    }
                    if (otherCount > 2) {
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }

                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }

    }
}


@Composable
fun ButtonSection(
    modifier: Modifier = Modifier
) {
    val minWidth = 95.dp
    val height = 30.dp
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {
        if (text != null) {
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}


@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlights: List<ImageWithText>
) {
    LazyRow(modifier = modifier) {
        items(highlights.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(end = 15.dp)
            ) {
                RoundImage(
                    image = highlights[it].image,
                    modifier = Modifier.size(70.dp)
                )
                Text(
                    text = highlights[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )


            }
        }
    }
}


@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithTexts: List<ImageWithText>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        containerColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        imageWithTexts.forEachIndexed { index, item ->
            Tab(
                selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }
            ) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if (selectedTabIndex == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }


    }
}


@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier
) {
    val chunkedPosts = posts.chunked(3)

    Column(modifier = modifier) {
        chunkedPosts.forEach { rowPosts ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(1.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                rowPosts.forEach { post ->
                    Image(
                        painter = post,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f)
                            .border(
                                width = 1.dp,
                                color = Color.White
                            )
                    )
                }
                // Add dummy Spacers for remaining items
                for (i in rowPosts.size until 3) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}


@Composable
fun ReelsSection(
    reels: List<ImageWithText>,
    modifier: Modifier = Modifier
) {
    val chunkedPosts = reels.chunked(3)

    Column(modifier = modifier) {
        chunkedPosts.forEach { rowReels ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(1.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                rowReels.forEach { reels ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        // Reel Preview Image
                        Image(
                            painter = reels.image,
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .aspectRatio(9 / 16f)
                                .border(
                                    width = 1.dp,
                                    color = Color.White
                                )
                        )

                        Row(
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(8.dp)
                        ) {
                            // Overlay reel icon with views count
                            Image(
                                painter = painterResource(id = R.drawable.play_icon),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(18.dp)
                            )
                            Spacer(Modifier.width(4.dp))

                            Text(
                                text = reels.text,  //views count of the reel
                                fontSize = 12.sp,
                                color = Color.White,
                            )
                        }

                    }


                }
                // Add dummy Spacers for remaining items
                for (i in rowReels.size until 3) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}




















