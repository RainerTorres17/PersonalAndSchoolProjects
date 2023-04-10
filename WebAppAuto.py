from fabric import Connection


c = Connection('172.31.88.195', user = "Rainer", connect_kwargs={'key_filename': '/Users/rainertorres/Downloads/IMPORTANT/Skeleton2023'})

c.put('local_path', 'remote_path')

c.run('Install dependencies')

c.run('path to app')