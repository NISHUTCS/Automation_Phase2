set projectLocation=F:\Automation\Nishant\RestSampleColumbine\RestSample
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\startTest.xml

cd %projectLocation%
iHTSOA.bat

Pause 