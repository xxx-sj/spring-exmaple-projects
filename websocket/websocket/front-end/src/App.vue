<template>
  <div style="width: 100%; height: 100%;">
    <div style="width: 100%; height: 100%; padding: 30px; display: flex; align-items: center; justify-content: center;">
      <section class="room-list" style="width: 400px; height: 600px;  border: 1px solid black; margin-right: 2px;">
        <section class="room-tab" style="width: 100%; height: 50px; display: flex; flex-wrap: nowrap; justify-content: space-evenly; align-items: center">
          <div :class="activeRoomTab === 'ALL' ? 'active-all-room': 'all-room'" @click="activeTab('ALL')">전체 채팅 방</div>
          <div :class="activeRoomTab === 'MINE'? 'active-my-room': 'my-room'" @click="activeTab('MINE')">내가 속한 채팅 방</div>
        </section>
        <section style="width: 100%; height: calc(100% - 50px);  overflow: scroll;">
          <keep-alive>
            <div style="overflow: hidden">
              <template v-if="activeRoomTab ==='ALL'">
                <template v-for="room in rooms" :key="room">
                  <section style="padding: 5px;">
                    <div class="room-item" >
                      <p>{{room.name}}</p>
                    </div>
                  </section>

                </template>
              </template>
              <template v-else>
                <template v-for="room in enteredRooms" :key="room">
                  <section style="padding: 5px;">
                    <div class="room-item" >
                      <p>{{room.name}}</p>
                    </div>
                  </section>
                </template>
              </template>
            </div>
          </keep-alive>
        </section>
      </section>
      <section class="chat-area" style="width: 600px; height: 600px;  border: 1px solid black;">

      </section>
    </div>
  </div>
</template>

<script>


export default {
  name: 'App',

  data() {
    return {
      activeRoomTab: "ALL",
      rooms: [],
      enteredRooms: [],
      isLoading: false,
    };
  },

  computed: {
    activatedRoomTab() {

      return "a";
    },
  },

  created() {
    this.loadRooms();
  },

  mounted() {
    this.rooms = this.$store.getters['user/rooms'];
    this.enteredRooms = this.$store.getters['user/enteredRooms'];
  },

  methods: {
    async loadRooms() {
      this.isLoading = true;
      try {
        await this.$store.dispatch('user/loadRooms')
        await this.$store.dispatch('user/loadEnteredRooms');

        this.rooms = this.$store.getters['user/rooms'];
        this.enteredRooms = this.$store.getters['user/enteredRooms'];
        console.log(this.rooms[0]);
        console.log(this.enteredRooms)
      } catch(error) {
        console.log(error)
      }

      this.isLoading = false;
    },


    activeTab(activeTab) {
      this.activeRoomTab = activeTab;
    }
  },
}
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap");

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

* {
  box-sizing: border-box;
}
body {
  margin: 0;
}

html {
  font-family: "ROboto", sans-serif;
}

.all-room {
  border-radius: 5px;
  padding: 10px;
  background: rgba(154, 175, 154, 0.45);
  cursor: pointer;
}

.all-room:hover {
  background: rgba(0, 245, 0, 0.85);
}

.my-room {
  border-radius: 5px;
  padding: 10px;
  background: rgba(154, 175, 154, 0.45);
  cursor: pointer;
}
.active-my-room {
  border-radius: 5px;
  padding: 10px;
  background: rgba(0, 245, 0, 0.85);
  cursor: pointer;
}

.active-all-room {
  border-radius: 5px;
  padding: 10px;
  background: rgba(0, 245, 0, 0.85);
  cursor: pointer;
}

.my-room:hover {
  background: rgba(0, 245, 0, 0.85);
}

.room-item {
  width: 100%;
  height: 70px;
  background: #25ab25;
  border-radius: 10px;
  display: flex;
  align-content: center;
  justify-content: center;
  align-items: center;
  cursor: pointer;
}

.room-item:hover {
  background: #1bce1b;
}

.room-item > p {
  font-size: 20px;
  font-weight: 800;
  color: white;
}
</style>
