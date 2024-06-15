import { spawn } from 'child_process';
import * as readline from 'readline';


// Path to the Java app
export function runJavaApp() {

    const jar = '../jobs4u.app.backoffice.console/target/jobs4u.app.backoffice.console-0.1.0.jar;../jobs4u.app.backoffice.console/target/dependency/*;';
    const javaClass = 'lapr4.jobs4u.app.backoffice.console.BackOfficeApp';

    // Create a child process for the Java app
    const javaApp = spawn('java', ['-cp', jar, javaClass]);

    // Handle output from the Java app
    javaApp.stdout.on('data', (data) => {
        console.log(data.toString());
    });

    // Handle errors from the Java app
    javaApp.stderr.on('data', (data) => {
        console.error(`Java app error: ${data}`);
    });


    // Handle the Java app closing
    javaApp.on('close', (code) => {
        console.log(`Java app exited with code ${code}`);
    });

    return javaApp;

}