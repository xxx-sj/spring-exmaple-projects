const { defineConfig } = require('@vue/cli-service')

const host = "localhost";
const port = "8081";
module.exports = defineConfig({
  transpileDependencies: true,

  outputDir: "../back-end/src/main/resources/static",


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
