# SimpleCleaner 자동 배포 스크립트

Write-Host "🚀 SimpleCleaner 배포 시작..." -ForegroundColor Cyan

# 1. Maven 빌드
Write-Host "📦 빌드 중..." -ForegroundColor Yellow
mvn clean package
if ($LASTEXITCODE -ne 0) {
    Write-Host "❌ 빌드 실패! 스크립트를 종료합니다." -ForegroundColor Red
    exit 1
}

# 2. 파일 복사
$Source = "target\SimpleCleaner.jar"
$Destinations = @(
    "..\survival\plugins\SimpleCleaner.jar",
    "..\lobby\plugins\SimpleCleaner.jar",
    "..\creative\plugins\SimpleCleaner.jar"
)

Write-Host "📂 파일 복사 중..." -ForegroundColor Yellow
foreach ($Dest in $Destinations) {
    Copy-Item $Source $Dest -Force
    Write-Host "   -> $Dest 복사 완료" -ForegroundColor Gray
}

# 3. 서버 리로드
Write-Host "🔄 서버 리로드 중..." -ForegroundColor Yellow

$Servers = @("minecraft-survival", "minecraft-lobby", "minecraft-creative")

foreach ($Server in $Servers) {
    Write-Host "   [$Server] 리로드..." -ForegroundColor Gray
    docker exec $Server rcon-cli "reload"
}

Write-Host "✅ 배포 완료! 모든 서버에 적용되었습니다." -ForegroundColor Green
