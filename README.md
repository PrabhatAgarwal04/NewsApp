# NewsApp

A simple Android application that fetches and displays the latest U.S. news headlines from NewsAPI.org.

## Features
- Displays a list of top U.S. headlines with description, author, and image.
- Uses a placeholder image if no image is available.
- Shows article details with likes and comments on click.
- Built with MVVM architecture, Jetpack Compose, Retrofit, and Room (scaffolded for future offline support).

## Prerequisites
- Android Studio (latest stable version)
- NewsAPI.org API key (replace `YOUR_NEWS_API_KEY` in `Module.kt`)

## Setup
1. Clone the repository:
2. Open the project in Android Studio.
3. Add your NewsAPI key in `Module.kt`:
```kotlin
  return NewsRepository(newsApiService, socialApiService, "YOUR_API_KEY")