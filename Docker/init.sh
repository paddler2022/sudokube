apt update
apt install -y vim \
htop \
bash \
tar \
wget \
byobu \
ca-certificates \
curl \
rsync \
make \
cmake  \
build-essential \
openjdk-8-jdk \
unzip \
rclone \
git


wget https://github.com/sbt/sbt/releases/download/v1.2.7/sbt-1.2.7.zip
unzip sbt-1.2.7.zip && mv sbt /opt/sbt && rm sbt-1.2.7.zip
echo "export PATH=/var/data/sudokube/sudokube/scripts:/opt/sbt/bin:$PATH" >> /root/.profile
echo "export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64" >> /root/.profile

#copy rclone conf
mkdir -p /var/data/sudokube/sudokube
cd /var/data/sudokube/sudokube
mkdir tabledata expdata
rclone copy skRW:12327-755e92f906ff1f273f45a3a76785476f/new  cubedata -P --multi-thread-streams 20 --transfers=4   --cache-workers=16 --checkers=16
rclone copy --include "*.uniq" skRW:12327-755e92f906ff1f273f45a3a76785476f/tabledata tabledata   -P --multi-thread-streams 20 --transfers=10 --cache-workers=16 --checkers=16
#sync
#sbt compile
#make shared lib !
#copy .jvmpopts


