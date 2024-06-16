REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET jobs4u_CP=..\jobs4u.app.candidate.console\target\jobs4u.app.candidate.console-0.1.0.jar;..\jobs4u.app.candidate.console\target\dependency\*;
SET jobs4u_MAIN= lapr4.jobs4u.app.candidate.console.CandidateApp

start /D jobs4u.eletron cmd /C npm start %jobs4u_CP% %jobs4u_MAIN%