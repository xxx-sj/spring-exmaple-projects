import { createApp } from 'vue'

// import router from '@/router'
import store from "@/store"
import App from './App.vue'

createApp(App).mount('#app')

const app = createApp(App);

// app.use(router)
app.use(store)

app.mount("#app")