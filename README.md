# SiguriaeteDhenave-31

# Faza 1
Four-square Cipher eshte teknik manuale e kriptimit simetrik e cila perdor kater matrica 5x5.
Kodi i Four-square Cipher eshte zhvilluar me dy input celesa, pas futjes se celesave ndodh procesi i enkriptimit dhe dekriptimit.<br/>
Kur kemi plaintext me gjatesi teke ne ato raste ia shtojme nje X plaintext-it ne fund. Si dhe per shkronjat I dhe J jane konsideru si te njejta.<br/>
Te dy metodat e enkriptimit dhe dekriptimi ekzekutohen, si dhe ne teresi detyra implementohet si console me inicim permes parametrave dhe si desktop app. Realizimin e tyre e kemi bere me ane te gjuhes programuese Java.<br/>
**Gjithsesi ka metoda me eficiente per te zhvilluar kodin me me pak loop-s.**

## Realizimi
Implementimi final i kodit permban tri variabla hyrese: teksti, qelesi1 dhe qelesi2. Si dhe Four-Square Cipher realizohet me kater matrica 5x5: tpleft->TOP LEFT, tpright->TOP RIGHT; btmleft->BOTTOM LEFT, btmright->BOTTOM RIGHT.



> Funksionet
1. funksioni_enkriptimit
2. funksioni_dekriptimit

> Komandat kryesore te perdorura ne funksione
- enkriptimi (plaintexti konvertohet në ciphertext)
- dekriptimi (ciphertext konvertohet ne plaintext)





# Implementimi
- [x] Implementimi si console me inicim te parametrave
- [x] Implementimi si dekstop app
- [x] Ekzekutimi i te dy metodave asaj te enkriptimit dhe asaj te dekriptimit


# Referencat
1. https://stackoverflow.com/questions/33703685/four-square-cipher-encryption-code
2. https://www.youtube.com/watch?v=PwHkSTh5uB4&t=4s
3. https://www.youtube.com/watch?v=53V3QKjYmpg&list=PLF4GQnPUdprCBj-ez_FCNNo7jfErUVeKu&index=2
4. http://practicalcryptography.com/ciphers/four-square-cipher/
 


# Faza 2

> Serveri
1. Të shkruhet një UDP server i autorizimit i cili ruan shfrytezuesit në mënyrë të sigurt
në bazë të shënimeve MYSQL duke shfrytëzuar teknikat e salted hashing për ruajtje të fjalëkalimeve.
2. Përveç informatave të shfrytëzuesit, serveri i autorizimit ruan të dhënat e shpenzimeve
(lloji fatures, viti, muaji, vlera ne euro) për shfrytëzuesin. Shfrytëzuesi duhet ta ketë së
paku edhe një atribut shtesë sipas dëshirës.
3. Serveri i autorizimit ka një çelës publik X.509 i cili dihet paraprak- isht nga të gjitha
palët tjera.

> Klienti
1. Të shkruhet një klient i cili ofron dy shërbime: krijimi i shfrytëzuesve, qasja në llogarinë e
shfrytëzuesve ekzistues dhe regjistrimi i shpenzimeve.
2. Procesi i regjistrimit shkon duke ia dërguar të dhënat e shfrytëzuesit serverit të
autorizimit i cili kthen përgjigjen përkatëse (OK ose ERROR).
3. Procesi i qasjes (login) shkon duke ia dërguar llogarinë dhe fjalëkalimin serverit të
autorizimit i cili kthen përgjigjen përkatëse (OK ose ERROR).
4. Në rast të qasjes (login) me sukses serveri i autorizimit duhet ta kthejë një JWT të nënshkruar me çelësin e vet privat në të cilin gjenden faktet rreth shfrytëzuesit (id, të dhënat e shfrytëzuesit).
5. Klienti duhet ta vërtetojë nënshkrimin e serverit dhe në rast suksesi duhet ta shfaqë një pamje ku gjenden faktet rreth shfrytëzuesit. Në rast të dështimit të validimit të nënshkrimit të shfaqet mesazhi përkatës i gabimit.

## Komunikimi klient-server
Të gjitha kërkesat që klienti i dërgon te serveri i autorizimit duhet të jenë të enkriptuara me CBC DES.

