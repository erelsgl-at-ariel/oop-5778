echo -- add --
/usr/bin/git add -A
echo -- commit --
/usr/bin/git commit -m "Deploying"
echo -- pull --
/usr/bin/git pull
echo -- push --
/usr/bin/git push
ssh root@162.243.116.217 'cd ariel-oop-course/week10-gradle/25-tricks; git pull; ./gradlew hello launch'
