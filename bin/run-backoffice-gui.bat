REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET jobs4u_CP=..\jobs4u.app.backoffice.console\target\jobs4u.app.backoffice.console-0.1.0.jar;..\jobs4u.app.backoffice.console\target\dependency\*;
SET jobs4u_MAIN= lapr4.jobs4u.app.backoffice.console.BackOfficeApp

start /D jobs4u.eletron cmd /C npm start %jobs4u_CP% %jobs4u_MAIN%