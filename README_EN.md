# SimpleCleaner 🧹

[🇰🇷 한국어](README.md) | [🇺🇸 English](README_EN.md)

**SimpleCleaner** is a lightweight plugin that periodically removes dropped items to reduce lag on Minecraft servers.

## ✨ Key Features

- ⏰ **Auto Clean**: Automatically removes dropped items every 5 minutes.
- ⚠️ **Warning Messages**: Broadcasts warning messages 30 seconds and 5 seconds before cleaning.
- 🧹 **Manual Clean**: Instantly remove items via command.
- 🚀 **Optimized**: Minimized operations to ensure no impact on server performance.

## 📥 Installation

1. Download the latest `.jar` file from the [Releases](https://github.com/minseok7891/minecraft-cleanbot/releases) tab.
2. Place the file in your server's `plugins` folder.
3. Restart or reload the server.

## 💻 Commands & Permissions

| Command | Description | Permission |
| :--- | :--- | :--- |
| `/cleandrop` | Instantly removes dropped items. | `simplecleaner.cleandrop` |

## ⚙️ Configuration

The current version works with default settings (5-minute interval) without a separate configuration file.

## 🛠️ Build Instructions

### Prerequisites
- **Java JDK 21** or higher
- **Maven** 3.x or higher

### Build Command
You can build this project using Maven.

```bash
mvn clean package
```

Once the build is complete, the `target/SimpleCleaner.jar` file will be generated.

## 📝 License

This project follows the MIT License.
