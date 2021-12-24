<div align="center">
  <img src="https://user-images.githubusercontent.com/24686636/147353418-e1df2ff0-d5c1-46a7-b65b-03cda083667b.png" alt="title" style="border-top-left-radius: 10px; border-bottom-right-radius: 10px;" />
</div>

### :pushpin: Not

Bu proje Kocaeli Üniversitesi VII. Döneminde bulunan Mobil Programlama dersi kapsamında hazırlanmıştır.

# Mobil Garson

Kullanıcıların istedikleri yemeği, içeriğini görerek kolayca sipariş edebilmesini sağlayan bir mobil sipariş uygulamasıdır.

## :gear: Teknolojiler

- [Firebase](https://github.com/firebase/firebase-ios-sdk)
- [Kotlin](https://developer.android.com/kotlin?gclid=Cj0KCQiA_JWOBhDRARIsANymNOYYQZ6sq0EJRly0DDZoxGGYT49zsGCbuJKyQZb2EYz-PNEuI2F9ieAaAk10EALw_wcB&gclsrc=aw.ds)
- [Photoshop](https://www.adobe.com/tr/products/photoshop.html)
- [Android Studio](https://developer.android.com/studio?gclid=Cj0KCQiA_JWOBhDRARIsANymNOYfWt-U0UcFIXkOwDSTZs7q8Yz-okesn8M3_TyeAF5JLFw6FvF0u-8aAmu4EALw_wcB&gclsrc=aw.ds)

Veritabanı ve kullanıcı kaydı işlemleri için Firebase kullanıldı.<br/>
Uygulama Android Studio'da Kotlin ile geliştirildi.<br/>
Görseller Photoshop ile hazırlandı.<br/>

## :sparkles: Temel Özellikler

  - Uygulamaya kullanıcı kaydı yapılabiliyor.
  - Kayıtllı kullanıcılar email ve şifre bilgileriyle uygulamaya giriş yapabiliyor.
  - Kullanıcı bilgileri, yemeklere dair bilgiler ve görseller Firebase bulut veritabanında tutuluyor.
  - Kullanıcı şifresini unuttuğunda şifre resetleme işlemini yapabiliyor.
  - Seçilen ürünü satın alma işlemi yapılabiliyor.
  - Uygulamanın çalışması için Wi-Fi gerekmekte, bu sebeple her 3 saniyede bir wifi bağlantısı kontrol ediliyor.
  - Uygulamaya giriş yapıldığında Category ekranı açılıyor.
  - Kullanıcı seçtiği yemeğin, tatlının, salatanın veya içeceğin içeriğindeki ürünleri görebiliyor.

## :computer: Kurulum
  
  - Projeyi çalıştırabilmek için Android Studio ve Git bilgisayarınızda kurulu olmalıdır. Git terminalini açıp şu ifadeyi ``git clone https://github.com/mehtapugur/MobilGarson.git`` yazıp enter tuşuna bastığınızda proje localinize inmiş olacaktır. Ardından projeyi android studioda açıp emülatörde çalıştırabilirsiniz.<br/><br/>

## :page_with_curl: Ders Özeti (Müfredat) içerisinde Kullandıklarımız

- Kalıcı Veri Yönetimi
  - Veritabanı Sistemleri (RDBMS/NoSQL): Firebase kullanıldı
- Ağ İletişimi / Web / Bulut
  - Wi-Fi
- Donanım / Sensör / Konum
  - Wi-Fi kullanıldı, bağlantı olmadan uygulamamız çalışmamakta bu sebeple 3 saniyede bir bağlantı kontrolü yapılmaktadır.
- Kullanıcı Arayüzü
  - Arayüz Bileşenleri
  - Dokunma / Giriş Yöntemleri
  - Görüntü / Multimedia  
- Güvenlik / Gizlilik Politikaları
  - İzin / Yetki / Oturum Yönetimi
  - Gizlilik Politikaları ve Analitik Veriler
- Paketleme / Dağıtım
  - Uygulama Derleme: Uygulama derlenip test edilmiştir. </br></br>

## :camera_flash: Ekran Görüntüleri

| Icon | Home | Kullanıcı Kaydı | Şifre Yenileme |
| --- | --- | --- | --- |
| ![Preview](https://user-images.githubusercontent.com/24686636/147360711-12b7337d-93bb-426a-b90b-3cdbdd319460.png) | ![Preview](https://user-images.githubusercontent.com/24686636/147360749-9a4f7941-8b1e-4b0d-96be-0a4720031607.png) | ![Preview](https://user-images.githubusercontent.com/24686636/147360861-a63d3a8c-53bd-4e73-9592-3c548f7cb5e2.png) | ![Preview](https://user-images.githubusercontent.com/24686636/147360984-8c9da7f6-c450-4935-b7b5-12448cd85310.png) |

| Menü | Ürün Detay | Satın Alma Ekranı |
| --- | --- | --- |
| ![Preview](https://user-images.githubusercontent.com/24686636/147361109-469fad6d-6855-4bdc-8192-0559435faf50.png) | ![Preview](https://user-images.githubusercontent.com/24686636/147361131-ac47dee1-9c36-4e81-8ca3-412cbb654c32.png) | ![Preview](https://user-images.githubusercontent.com/24686636/147362025-195b8fb8-6141-4fbf-bba7-6506b63ea03c.png) |

| Salata | Tatlı | Firebase |
| --- | --- | --- |
| ![Preview](https://user-images.githubusercontent.com/24686636/147361994-296403f5-da70-4029-b215-380541d21b8b.png) | ![Preview](https://user-images.githubusercontent.com/24686636/147361982-ea524939-ac21-45fe-b531-22b4cae8c1d2.png) | ![Preview](https://user-images.githubusercontent.com/24686636/147361757-8c07597f-fcbb-4501-9476-4afdf6611e22.png) |

| Şifre Değiştirilmesi | Şifre Değiştirme Linki |
| --- | --- |
| ![Preview](https://user-images.githubusercontent.com/24686636/147361647-58610e43-dbc1-4ae0-b700-0840e96ce30f.png) | ![Preview](https://user-images.githubusercontent.com/24686636/147361658-3df9ddd6-6052-4198-ad2e-878baa0d6051.png) |

| DB Bilgileri | Ürün Bilgisi |
| --- | --- |
| ![Preview](https://user-images.githubusercontent.com/24686636/147362149-c817cea9-6c47-454b-92d0-c1d70f53c893.png) | ![Preview](https://user-images.githubusercontent.com/24686636/147362177-f2bf5924-734b-4d5d-900f-efa349ecfee6.png) |

## :camera_flash: Proje Kodları

| Wi-Fi Bağlantı Kontrolü | Wi-Fi Bağlantı |
| --- | --- |
| ![Preview](https://user-images.githubusercontent.com/24686636/147362332-f45a4761-692a-4b5b-a3db-010eb8141e6e.png) | ![Preview](https://user-images.githubusercontent.com/24686636/147362565-592c2093-1fe4-4f7d-9ca3-e727a5341c5d.png) |

| Kategori Listeleme| Detay Sayfası |
| --- | --- |
| ![Preview](https://user-images.githubusercontent.com/24686636/147362332-f45a4761-692a-4b5b-a3db-010eb8141e6e.png) | ![Preview](https://user-images.githubusercontent.com/24686636/147362431-ccbd1122-170a-403d-ab1f-ac97d7453487.png) |

| Giriş | Kayıt |
| --- | --- |
| ![Preview](https://user-images.githubusercontent.com/24686636/147362607-dcbe39aa-33b8-4ece-88eb-69c2976f6024.png) | ![Preview](https://user-images.githubusercontent.com/24686636/147362640-61760814-cbbf-490b-944f-851f8b9f23c2.png) |

| Şifre Resetleme | Firebase - User Doğrulama |
| --- | --- |
| ![Preview](https://user-images.githubusercontent.com/24686636/147362742-bc0ec528-4865-4d52-b0f6-504bcee52e13.png) | ![Preview](https://user-images.githubusercontent.com/24686636/147362729-c5f2f824-c789-45ba-acfc-c33fe985d607.png) |

| Sipariş |
| --- |
| ![Preview](https://user-images.githubusercontent.com/24686636/147362765-bb516720-b9fd-4c10-b03e-9ed57ba4491c.png) |

## :memo: Lisans
Bu proje MIT lisansı ile korunmaktadır.
<br/>
<br/>
İletişim: [LinkedIn](https://www.linkedin.com/in/mehtapugur)
