const { defineConfig } = require('@vue/cli-service')
const path = require("path")

const host = "localhost";
const port = "8081";

//D:\study_folder\spring_examples\websocket\websocket\front-end
// console.log("__dirname", __dirname)

module.exports = defineConfig({
  transpileDependencies: true,

  outputDir: path.resolve(__dirname, "../back-end/src/main/resources/static"),


  devServer: {
    hot: true,
    proxy: {
      //http://localhost:8080/api/ -> http://localhost:8081/api/
      '/api/': {
        target: `http://${host}:${port}`,
        changeOrigin: true,
      },

      '/ws/': {
        target: `ws://${host}:${port}`,
        changeOrigin: false,
        ws: true,
      }
    }
  }
})
