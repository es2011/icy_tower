mode_recognition: 
receives image, exits when image appears

extrcat_score: 
receives profile stats location and requested qr location
generates QRcode with the best score

examples:

java -jar mode_recognition.jar high_score.jpg

java -jar mode_recognition.jar game_over.jpg

java -jar extract_score.jar C:\\games\\icytower1.5\\profiles\\icy\\icy_stats.txt c:\\temp\\score.jpg

