mode_recognition: 
receives image, exits when image appears

extrcat_score: 
args[0]- icy tower stats location
args[1]- property file location
args[2]- number of miliis to sleep before closing image
args[3]- photo program

examples:

java -jar mode_recognition.jar high_score.jpg

java -jar mode_recognition.jar game_over.jpg

java -jar extract_score.jar C:\\games\\icytower1.5\\profiles\\icy\\icy_stats.txt c:\\temp\\scores.properties 5000 WLXPhotoGallery

