@echo off
cd API
git pull origin master
cd ../CodeGenerator
git pull origin master
cd ../Engine
git pull origin development
cd ../Lib-Access
git pull origin master
cd ../ModCompat
git pull origin master
cd ../ModFlags
git pull origin master
cd ../Prefabs
git pull origin master
cd ../Minecraft-1.7
git pull origin master
cd ..
@pause