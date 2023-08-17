@echo off
rm C:\Users\ajay-winX\Downloads\0out.zip
for /f %%i in ('dir /s /q /b *__pycache__*') do rmdir /s /q "%%i"
rm .coverage
"C:\Program Files\7-Zip\7z.exe" a C:\Users\ajay-winX\Downloads\0out.zip *