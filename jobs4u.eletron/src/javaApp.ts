import { spawn } from 'child_process';

// Path to the Java app
export function runJavaApp(args: string[]) {

    const jar = args[0];
    const javaClass = args[1];

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