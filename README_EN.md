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

When you run the plugin for the first time, configuration files are generated in the `plugins/SimpleCleaner/` folder.
**You can edit these files to change settings without rebuilding the plugin.**

### `config.yml`
```yaml
# Language setting (en / ko)
lang: en

# Message Prefix
prefix: "&8[&bSimpleCleaner&8] "
```

### Customizing Messages
You can edit `messages_en.yml` or `messages_ko.yml` to customize in-game messages.

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
