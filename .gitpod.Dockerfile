FROM gitpod/workspace-full-vnc

USER gitpod

RUN sudo apt-get -q update && \
    sudo apt-get install -y libgtk-3-dev && \
    sudo apt-get install -yq libncurses5-dev && \
    sudo apt-get install -yq libncursesw5-dev && \
    sudo apt-get install -yq gcc-multilib && \
    sudo apt install -y libtinfo5 && \
    sudo rm -rf /var/lib/apt/lists/*

# Install custom tools, runtime, etc. using apt-get
# For example, the command below would install "bastet" - a command line tetris clone:
#
# RUN sudo apt-get -q update && \
#     sudo apt-get install -yq bastet && \
#     sudo rm -rf /var/lib/apt/lists/*
#
# More information: https://www.gitpod.io/docs/config-docker/
