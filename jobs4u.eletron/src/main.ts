import { app, BrowserWindow, ipcMain } from "electron";
import { runJavaApp } from "./javaApp";
import * as path from "path";

function createWindow() {
  // Create the browser window.
  const mainWindow = new BrowserWindow({
    height: 600,
    webPreferences: {
      preload: path.join(__dirname, "preload.js"),

    },
    width: 800,
  });

  // and load the index.html of the app.
  mainWindow.loadFile(path.join(__dirname, "../index.html"));

}

// This method will be called when Electron has finished
// initialization and is ready to create browser windows.
// Some APIs can only be used after this event occurs.
app.whenReady().then(() => {
  createWindow();

  app.on("activate", function () {
    // On macOS it's common to re-create a window in the app when the
    // dock icon is clicked and there are no other windows open.
    if (BrowserWindow.getAllWindows().length === 0) createWindow();
  });
});

// Quit when all windows are closed, except on macOS. There, it's common
// for applications and their menu bar to stay active until the user quits
// explicitly with Cmd + Q.
app.on("window-all-closed", () => {
  if (process.platform !== "darwin") {
    app.quit();
  }
});

// Listen for 'log' event from renderer process
ipcMain.on('log', (event, ...args) => {
  console.log(...args); // Logs all arguments sent by the renderer process
});

ipcMain.on('login', (event, ...args) => {
  // divide the arguments
  const email = args[0];
  const password = args[1];

  // Send the email and password to the Java app
  javaApp.stdin.write('1\n');
  javaApp.stdin.write(`${email}\n`);
  javaApp.stdin.write(`${password}\n`);

});

// Connect to the Java app
const javaApp = runJavaApp();




