// This file is required by the index.html file and will
// be executed in the renderer process for that window.
// No Node.js APIs are available in this process unless
// nodeIntegration is set to true in webPreferences.
// Use preload.js to selectively enable features
// needed in the renderer process.
interface Window {
    mainProcess: {
        send: (type: string, ...arg: any) => void;
        receive: (type: string, func: (event: any, ...arg: any) => void) => void;
    };
}

document.getElementById('loginForm').addEventListener('submit', function (event) {
    // Prevent the form from submitting normally
    var email: string;
    var password: string;
    event.preventDefault();

    // Get the email and password
    email = (document.getElementById('email') as HTMLInputElement).value;
    password = (document.getElementById('password') as HTMLInputElement).value;

    //


    // Send the email and password to the main process
    window.mainProcess.send('login', email, password);
});