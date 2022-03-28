# MyFreeCatsApp
TheCatApi implementation in Android with Kotlin, just for my portfolio

Here you can see a solution how to hide the API_KEY
1. add the file with dummy content or even without. The real content in this case it will be something like this: CAT_API_KEY="string-with-length-of-36-chars"
2. add to .gitignore and it will not updated, just by mistake...
3. add a few lines to build.gradle to load that file as a Properies file
4. do a test to make sure it is loaded and can be used

A screenshot from Test can be seen:
![Alt text](/screenshots/Screenshot%202022-03-28%20at%2000.55.59.png?raw=true "Optional Title")

A random cat loading screenshot:
![Alt text](/screenshots/Screenshot_20220328_040352.png?raw=true "Optional Title")
