#default run
/Users/mykhailo.mikus/Downloads/apache-jmeter-5.5/bin/jmeter -n -t Mantis_lod.jmx

#custom run
/Users/mykhailo.mikus/Downloads/apache-jmeter-5.5/bin/jmeter -n -t Mantis_lod.jmx -Jduration=100

#report
/Users/mykhailo.mikus/Downloads/apache-jmeter-5.5/bin/jmeter -g summary.csv -o report