sudo apt-get update
echo "Instalando o curl e o git"
sudo apt-get install -y git curl
echo "Instalando nvm"

export HOME=/home/vagrant
curl -o- https://raw.githubusercontent.com/creationix/nvm/v0.33.0/install.sh | bash
echo "source ~/.nvm/nvm.sh" >> /home/vagrant/.bashrc
source /home/vagrant/.nvm/nvm.sh
echo "NVM instalado"

chown vagrant:vagrant /home/vagrant/.nvm -R

nvm install 6.7.0
nvm use default
