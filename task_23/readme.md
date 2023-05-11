docker pull jenkins/jenkins
docker run -p 9000:8080 -d -v /Users/mykhailo.mikus/IdeaProjects/itstep/itstep_2023/task_23/jenkins_home:/var/jenkins_home jenkins/jenkins
docker container ls
docker logs fff9ec22007d
docker kill 51bfe7a21f25