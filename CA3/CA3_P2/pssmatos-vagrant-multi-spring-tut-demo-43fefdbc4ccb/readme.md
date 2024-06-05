# Vagrant Multi VM Demonstration for Spring Basic Tutorial Application

This project demonstrates how to setup two VMs for running the Spring Basic Tutorial application.

**web** VM:

  - Executes the web application inside Tomcat9

**db** VM:

  - Executes the H2 database as a server process. The web application connects to this VM.

This vagrant setup uses the spring application available at [https://bitbucket.org/pssmatos/tut-basic-gradle](https://bitbucket.org/pssmatos/tut-basic-gradle).

**Important** You should replace this version of the spring application with your own. Do not forget to replicate the necessary changes in our own version! These regard essentially the support for using H2 in server mode (as opposed to memory mode).

## Requirements

  Install Vagrant and VirtualBox in you computer (For macOS with M1/M2 processors jump section bellow).

## Steps

### 1

Create a local folder in your computer and copy the Vagrantfile into that folder

### 2

Execute **vagrant up**

This will create two vagrant VMs (i.e, "db" and "web"). The first run will take some time because both machines will be provisioned with several software packages.

### 3

In the host you can open the spring web application using one of the following options:

  - http://localhost:8080/basic-0.0.1-SNAPSHOT/
  - http://192.168.56.10:8080/basic-0.0.1-SNAPSHOT/

You can also open the H2 console using one of the following urls:

- http://localhost:8080/basic-0.0.1-SNAPSHOT/h2-console
- http://192.168.56.10:8080/basic-0.0.1-SNAPSHOT/h2-console

For the connection string use: jdbc:h2:tcp://192.168.56.11:9092/./jpadb


# For macOS computers with M1/M2 CPUs

We need to use a different provider since VirtualBox for arm is beta, emulated and full of bugs.
- Make shure you have xcode command line DevTools and homebrew installed
  - Run in the terminal (you may need to first install xcode from AppStore)
    ```
    sudo xcode-select --install
    ```

  - Run this step if you don't have Homebrew package manager installed on your system.
    ```
    /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
    ```

- Install QEMU/libvirt (even if you have UTM installed)
  - First install QEMU
    ```
    brew install qemu
    ```

  - Install `libvirt` library
    ```
    brew install libvirt
    ```

- Install `vagrant` and plugins (run following commands on terminal)
  - Install vagrant from Hashicorp tap (preferred over community version)
    ```
    brew install hashicorp/tap/hashicorp-vagrant
    ```

  - Install vagrant provider `vagrant-qemu` (run following command on terminal)
    ```
    vagrant plugin install vagrant-qemu 
    ```
  
- Now you use vagrant with qemu provider
  - Create a local folder in your computer and copy the contents of the macOS folder
  - Execute **sudo vagrant up** (you need `sudo` for the network to be configured correctly)
  - You can continue with the rest of the step 2 above

**Notes**
- Because the machines were created using sudo, all vagrant commands for these machines also need sudo, ex: 
    `sudo vagrant ssh`, `sudo vagrant destroy`, etc.
- Sometimes, when you do `vagrant up`, one error about *"used ports"* shows up. Normally, this error means one machine 
    *"hanged"* and didn't end correctly. 
  - You can check running machines with: `vagrant global-status` and then destroy them using the hash code
  - If nothing shows up, do a `ps aux|grep qemu` and if some `qemu-system-aarch64` processes show up, kill them 
    with `kill -9 PID` (replacing the PID with the number on the second column after root)
