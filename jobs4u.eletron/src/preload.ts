// All of the Node.js APIs are available in the preload process.
// It has the same sandbox as a Chrome extension.

// preload.js
const { contextBridge, ipcRenderer } = require('electron');

// Comunicate with main process
contextBridge.exposeInMainWorld(
    'mainProcess',
    {
        send: (type: string, ...args: any) => {
            ipcRenderer.send(type, args);
        },
        receive: (type: string, func: any) => {
            ipcRenderer.on(type, (event, ...args) => func(...args));
        }
    }
);