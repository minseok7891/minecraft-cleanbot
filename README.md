# SimpleCleaner 🧹

[🇰🇷 한국어](README.md) | [🇺🇸 English](README_EN.md)

**SimpleCleaner**는 마인크래프트 서버의 렉을 줄이기 위해 바닥에 떨어진 아이템을 주기적으로 삭제해주는 경량 플러그인입니다.

## ✨ 주요 기능

- ⏰ **자동 청소**: 5분마다 바닥에 떨어진 아이템을 자동으로 삭제합니다.
- ⚠️ **경고 메시지**: 청소 30초 전과 5초 전에 경고 메시지를 방송하여 플레이어에게 알립니다.
- 🧹 **수동 청소**: 명령어를 통해 즉시 아이템을 삭제할 수 있습니다.
- 🚀 **최적화**: 불필요한 연산을 최소화하여 서버 성능에 영향을 주지 않습니다.

## 📥 설치 방법

1. [Releases](https://github.com/minseok7891/minecraft-cleanbot/releases) 탭에서 최신 `.jar` 파일을 다운로드합니다.
2. 서버의 `plugins` 폴더에 파일을 넣습니다.
3. 서버를 재시작하거나 리로드합니다.

## 💻 명령어 및 권한

| 명령어 | 설명 | 권한 |
| :--- | :--- | :--- |
| `/cleandrop` | 바닥에 떨어진 아이템을 즉시 삭제합니다. | `simplecleaner.cleandrop` |

## ⚙️ 설정

플러그인을 처음 실행하면 `plugins/SimpleCleaner/` 폴더에 설정 파일들이 생성됩니다.
**빌드 후에도 이 파일들을 수정하여 설정을 변경할 수 있습니다.**

### `config.yml`
```yaml
# 언어 설정 (en / ko)
lang: ko

# 메시지 접두사
prefix: "&8[&bSimpleCleaner&8] "
```

### 메시지 수정
`messages_ko.yml` 또는 `messages_en.yml` 파일을 직접 수정하여 게임 내 메시지를 마음대로 바꿀 수 있습니다.

## 🛠️ 빌드 방법

### 전제 조건
- **Java JDK 21** 이상
- **Maven** 3.x 이상

### 빌드 명령어
이 프로젝트는 Maven을 사용하여 빌드할 수 있습니다.

```bash
mvn clean package
```

빌드가 완료되면 `target/SimpleCleaner.jar` 파일이 생성됩니다.

## 📝 라이선스

이 프로젝트는 MIT 라이선스를 따릅니다.
