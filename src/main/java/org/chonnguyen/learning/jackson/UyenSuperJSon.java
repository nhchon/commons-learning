/*************************************************************************
 *  Copyright (c) Metabiota Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to Metabiota Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to Metabiota Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from Metabiota Incorporated.
 *************************************************************************/
package org.chonnguyen.learning.jackson;
import org.json.*;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by nhchon on 12/14/2017 11:10 AM.
 */
public class UyenSuperJSon {
    public static void main(String[] args) {
        String jsonStrData = "[\n" +
                "  {\n" +
                "    \"countryCode\": \"BW\",\n" +
                "    \"country\": \"Botswana\",\n" +
                "    \"states\": {\n" +
                "      \"GH\":\"Ghanzi\",\n" +
                "      \"KG\":\"Kgalagadi\",\n" +
                "      \"NW\":\"North West\",\n" +
                "      \"CE\":\"Central\",\n" +
                "      \"KL\":\"Kgatleng\",\n" +
                "      \"KW\":\"Kweneng\",\n" +
                "      \"SE\":\"South East\",\n" +
                "      \"SO\":\"Southern\",\n" +
                "      \"NE\":\"North East\",\n" +
                "      \"GA\":\"Gaborone\",\n" +
                "      \"FR\":\"Francistown\",\n" +
                "      \"LO\":\"Lobatse\",\n" +
                "      \"SP\":\"Selibe Phikwe\",\n" +
                "      \"ST\":\"Sowa Town\",\n" +
                "      \"JW\":\"Jwaneng\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"countryCode\": \"CO\",\n" +
                "    \"country\": \"Colombia\",\n" +
                "    \"states\": {\n" +
                "      \"AMA\":\"Amazonas\",\n" +
                "      \"ANT\":\"Antioquia\",\n" +
                "      \"BOY\":\"Boyaca\",\n" +
                "      \"COR\":\"Cordoba\",\n" +
                "      \"SAN\":\"Santander\",\n" +
                "      \"LAG\":\"La Guajira\",\n" +
                "      \"SAP\":\"San Andres\",\n" +
                "      \"CAL\":\"Caldas\",\n" +
                "      \"CUN\":\"Cundinamarca\",\n" +
                "      \"DC\":\"Distrito Capital de Bogota\",\n" +
                "      \"QUI\":\"Quindio\",\n" +
                "      \"RIS\":\"Risaralda\",\n" +
                "      \"TOL\":\"Tolima\",\n" +
                "      \"CAQ\":\"Caqueta\",\n" +
                "      \"CAU\":\"Cauca\",\n" +
                "      \"HUI\":\"Huila\",\n" +
                "      \"NAR\":\"Narino\",\n" +
                "      \"PUT\":\"Putumayo\",\n" +
                "      \"VAC\":\"Valle del Cauca\",\n" +
                "      \"ATL\":\"Atlantico\",\n" +
                "      \"BOL\":\"Bolivar\",\n" +
                "      \"CES\":\"Cesar\",\n" +
                "      \"CHO\":\"Choco\",\n" +
                "      \"MAG\":\"Magdalena\",\n" +
                "      \"SUC\":\"Sucre\",\n" +
                "      \"ARA\":\"Arauca\",\n" +
                "      \"NSA\":\"Norte de Santander\",\n" +
                "      \"CAS\":\"Casanare\",\n" +
                "      \"GUV\":\"Guaviare\",\n" +
                "      \"GUA\":\"Guainia\",\n" +
                "      \"MET\":\"Meta\",\n" +
                "      \"VAU\":\"Vaupes\",\n" +
                "      \"VID\":\"Vichada\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"countryCode\": \"ET\",\n" +
                "    \"country\": \"Ethiopia\",\n" +
                "    \"states\": {\n" +
                "      \"AM\":\"Amara\",\n" +
                "      \"TI\":\"Tigrai\",\n" +
                "      \"AF\":\"Afar\",\n" +
                "      \"SN\":\"Southern Nations Nationalities and Peoples\",\n" +
                "      \"GA\":\"Gambela Peoples\",\n" +
                "      \"OR\":\"Oromia\",\n" +
                "      \"BE\":\"Benshangul-Gumaz\",\n" +
                "      \"AA\":\"Addis Ababa\",\n" +
                "      \"SO\":\"Somali\",\n" +
                "      \"DD\":\"Dire Dawa\",\n" +
                "      \"HA\":\"Harari People\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"countryCode\": \"MA\",\n" +
                "    \"country\": \"Morocco\",\n" +
                "    \"states\": {\n" +
                "      \"01\":\"Tanger-Tetouan\",\n" +
                "      \"05\":\"Fes-Boulemane\",\n" +
                "      \"03\":\"Taza-Al Hoceima-Taounate\",\n" +
                "      \"02\":\"Gharb-Chrarda-Beni Hssen\",\n" +
                "      \"09\":\"Chaouia-Ouardigha\",\n" +
                "      \"08\":\"Grand Casablanca\",\n" +
                "      \"07\":\"Rabat-Sale-Zemmour-Zaer\",\n" +
                "      \"06\":\"Meknes-Tafilalet\",\n" +
                "      \"12\":\"Tadla-Azilal\",\n" +
                "      \"04\":\"L'Oriental\",\n" +
                "      \"13\":\"Souss-Massa-Draa\",\n" +
                "      \"11\":\"Marrakech-Tensift-Al Haouz\",\n" +
                "      \"10\":\"Doukhala-Abda\",\n" +
                "      \"15\":\"Laayoune-Boujdour-Sakia el Hamra\",\n" +
                "      \"14\":\"Guelmim-Es Semara\",\n" +
                "      \"16\":\"Oued ed Dahab-Lagouira\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"countryCode\": \"ML\",\n" +
                "    \"country\": \"Mali\",\n" +
                "    \"states\": {\n" +
                "      \"6\":\"Tombouctou\",\n" +
                "      \"8\":\"Kidal\",\n" +
                "      \"7\":\"Gao\",\n" +
                "      \"BKO\":\"Bamako\",\n" +
                "      \"1\":\"Kayes\",\n" +
                "      \"3\":\"Sikasso\",\n" +
                "      \"5\":\"Mopti\",\n" +
                "      \"4\":\"Segou\",\n" +
                "      \"2\":\"Koulikoro\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"countryCode\": \"NG\",\n" +
                "    \"country\": \"Nigeria\",\n" +
                "    \"states\": {\n" +
                "      \"BO\":\"Borno\",\n" +
                "      \"AB\":\"Abia\",\n" +
                "      \"AK\":\"Akwa Ibom\",\n" +
                "      \"IM\":\"Imo\",\n" +
                "      \"RI\":\"Rivers\",\n" +
                "      \"BY\":\"Bayelsa\",\n" +
                "      \"BE\":\"Benue\",\n" +
                "      \"CR\":\"Cross River\",\n" +
                "      \"TA\":\"Taraba\",\n" +
                "      \"KW\":\"Kwara\",\n" +
                "      \"LA\":\"Lagos\",\n" +
                "      \"NI\":\"Niger\",\n" +
                "      \"OG\":\"Ogun\",\n" +
                "      \"ON\":\"Ondo\",\n" +
                "      \"EK\":\"Ekiti\",\n" +
                "      \"OS\":\"Osun\",\n" +
                "      \"OY\":\"Oyo\",\n" +
                "      \"AN\":\"Anambra\",\n" +
                "      \"BA\":\"Bauchi\",\n" +
                "      \"GO\":\"Gombe\",\n" +
                "      \"DE\":\"Delta\",\n" +
                "      \"ED\":\"Edo\",\n" +
                "      \"EN\":\"Enugu\",\n" +
                "      \"EB\":\"Ebonyi\",\n" +
                "      \"KD\":\"Kaduna\",\n" +
                "      \"KO\":\"Kogi\",\n" +
                "      \"PL\":\"Plateau\",\n" +
                "      \"NA\":\"Nasarawa\",\n" +
                "      \"JI\":\"Jigawa\",\n" +
                "      \"KN\":\"Kano\",\n" +
                "      \"KT\":\"Katsina\",\n" +
                "      \"SO\":\"Sokoto\",\n" +
                "      \"ZA\":\"Zamfara\",\n" +
                "      \"YO\":\"Yobe\",\n" +
                "      \"KE\":\"Kebbi\",\n" +
                "      \"AD\":\"Adamawa\",\n" +
                "      \"FC\":\"Abuja Federal Capital Territory\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"countryCode\": \"SS\",\n" +
                "    \"country\": \"South Sudan\",\n" +
                "    \"states\": {\n" +
                "      \"BN\":\"Northern Bahr el Ghazal\",\n" +
                "      \"LK\":\"Lakes\",\n" +
                "      \"EW\":\"Western Equatoria\",\n" +
                "      \"EC\":\"Central Equatoria\",\n" +
                "      \"NU\":\"Upper Nile\",\n" +
                "      \"JG\":\"Jonglei\",\n" +
                "      \"UY\":\"Unity\",\n" +
                "      \"WR\":\"Warrap\",\n" +
                "      \"BW\":\"Western Bahr el Ghazal\",\n" +
                "      \"EE\":\"Eastern Equatoria\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"countryCode\": \"TZ\",\n" +
                "    \"country\": \"Tanzania\",\n" +
                "    \"states\": {\n" +
                "      \"14\":\"Mbeya\",\n" +
                "      \"20\":\"Rukwa\",\n" +
                "      \"11\":\"Kusini Unguja\",\n" +
                "      \"18\":\"Mwanza\",\n" +
                "      \"22\":\"Shinyanga\",\n" +
                "      \"24\":\"Tabora\",\n" +
                "      \"05\":\"Kagera\",\n" +
                "      \"08\":\"Kigoma\",\n" +
                "      \"02\":\"Dar es Salaam\",\n" +
                "      \"16\":\"Morogoro\",\n" +
                "      \"06\":\"Kaskazini Pemba\",\n" +
                "      \"10\":\"Kusini Pemba\",\n" +
                "      \"19\":\"Pwani\",\n" +
                "      \"07\":\"Kaskazini Unguja\",\n" +
                "      \"15\":\"Mjini Magharibi\",\n" +
                "      \"03\":\"Dodoma\",\n" +
                "      \"04\":\"Iringa\",\n" +
                "      \"12\":\"Lindi\",\n" +
                "      \"17\":\"Mtwara\",\n" +
                "      \"21\":\"Ruvuma\",\n" +
                "      \"23\":\"Singida\",\n" +
                "      \"01\":\"Arusha\",\n" +
                "      \"26\":\"Manyara\",\n" +
                "      \"09\":\"Kilimanjaro\",\n" +
                "      \"13\":\"Mara\",\n" +
                "      \"25\":\"Tanga\",\n" +
                "      \"28\":\"Katavi\",\n" +
                "      \"30\":\"Simiyu\",\n" +
                "      \"27\":\"Geita\",\n" +
                "      \"29\":\"Njombe\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"countryCode\": \"VE\",\n" +
                "    \"country\": \"Venezuela\",\n" +
                "    \"states\": {\n" +
                "      \"I\":\"Falcon\",\n" +
                "      \"C\":\"Apure\",\n" +
                "      \"E\":\"Barinas\",\n" +
                "      \"L\":\"Merida\",\n" +
                "      \"S\":\"Tachira\",\n" +
                "      \"T\":\"Trujillo\",\n" +
                "      \"V\":\"Zulia\",\n" +
                "      \"H\":\"Cojedes\",\n" +
                "      \"G\":\"Carabobo\",\n" +
                "      \"K\":\"Lara\",\n" +
                "      \"P\":\"Portuguesa\",\n" +
                "      \"U\":\"Yaracuy\",\n" +
                "      \"Z\":\"Amazonas\",\n" +
                "      \"F\":\"Bolivar\",\n" +
                "      \"B\":\"Anzoategui\",\n" +
                "      \"D\":\"Aragua\",\n" +
                "      \"X\":\"Vargas\",\n" +
                "      \"A\":\"Distrito Federal\",\n" +
                "      \"W\":\"Dependencias Federales\",\n" +
                "      \"J\":\"Guarico\",\n" +
                "      \"N\":\"Monagas\",\n" +
                "      \"M\":\"Miranda\",\n" +
                "      \"O\":\"Nueva Esparta\",\n" +
                "      \"R\":\"Sucre\",\n" +
                "      \"Y\":\"Delta Amacuro\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"countryCode\": \"YE\",\n" +
                "    \"country\": \"Yemen\",\n" +
                "    \"states\": {\n" +
                "      \"SD\":\"Saʻdah\",\n" +
                "      \"HU\":\"Al Hudaydah\",\n" +
                "      \"MW\":\"Al Mahwit\",\n" +
                "      \"DH\":\"Dhamar\",\n" +
                "      \"HJ\":\"Hajjah\",\n" +
                "      \"AM\":\"'Amran\",\n" +
                "      \"IB\":\"Ibb\",\n" +
                "      \"LA\":\"Lahij\",\n" +
                "      \"TA\":\"Ta'izz\",\n" +
                "      \"MR\":\"Al Mahrah\",\n" +
                "      \"BA\":\"Al Bayda'\",\n" +
                "      \"DA\":\"Ad Dali'\",\n" +
                "      \"JA\":\"Al Jawf\",\n" +
                "      \"SH\":\"Shabwah\",\n" +
                "      \"MA\":\"Ma'rib\",\n" +
                "      \"SN\":\"Sanʻa'\",\n" +
                "      \"HD\":\"Hadramawt\",\n" +
                "      \"SA\":\"Amanat al 'Asimah\",\n" +
                "      \"RA\":\"Raymah\",\n" +
                "      \"AD\":\"'Adan\",\n" +
                "      \"AB\":\"Abyan\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"countryCode\": \"CI\",\n" +
                "    \"country\": \"Côte d'Ivoire\",\n" +
                "    \"states\": {\n" +
                "      \"AB\":\"Abidjan\",\n" +
                "      \"BS\":\"Bas-Sassandra\",\n" +
                "      \"CM\":\"Comoe\",\n" +
                "      \"DN\":\"Denguele\",\n" +
                "      \"GD\":\"Goh-Djiboua\",\n" +
                "      \"LC\":\"Lacs\",\n" +
                "      \"LG\":\"Lagunes\",\n" +
                "      \"MG\":\"Montagnes\",\n" +
                "      \"SM\":\"Sassandra-Marahoue\",\n" +
                "      \"SV\":\"Savanes\",\n" +
                "      \"VB\":\"Vallee du Bandama\",\n" +
                "      \"WR\":\"Woroba\",\n" +
                "      \"YM\":\"Yamoussoukro\",\n" +
                "      \"ZZ\":\"Zanzan\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"countryCode\": \"ID\",\n" +
                "    \"country\": \"Indonesia\",\n" +
                "    \"states\": {\n" +
                "      \"AC\":\"Aceh\",\n" +
                "      \"BA\":\"Bali\",\n" +
                "      \"BB\":\"Bangka-Belitung Islands\",\n" +
                "      \"BT\":\"Banten\",\n" +
                "      \"BE\":\"Bengkulu\",\n" +
                "      \"GO\":\"Gorontalo\",\n" +
                "      \"PB\":\"West Papua\",\n" +
                "      \"JK\":\"Jakarta\",\n" +
                "      \"JA\":\"Jambi\",\n" +
                "      \"JB\":\"West Java\",\n" +
                "      \"JT\":\"Central Java\",\n" +
                "      \"JI\":\"East Java\",\n" +
                "      \"KB\":\"West Kalimantan\",\n" +
                "      \"KS\":\"South Kalimantan\",\n" +
                "      \"KT\":\"Central Kalimantan\",\n" +
                "      \"KI\":\"East Kalimantan\",\n" +
                "      \"KU\":\"North Kalimantan\",\n" +
                "      \"KR\":\"Riau Islands\",\n" +
                "      \"LA\":\"Lampung\",\n" +
                "      \"MU\":\"North Maluku\",\n" +
                "      \"MA\":\"Maluku\",\n" +
                "      \"NB\":\"West Nusa Tenggara\",\n" +
                "      \"NT\":\"East Nusa Tenggara\",\n" +
                "      \"PA\":\"Papua\",\n" +
                "      \"RI\":\"Riau\",\n" +
                "      \"SR\":\"West Sulawesi\",\n" +
                "      \"SN\":\"South Sulawesi\",\n" +
                "      \"ST\":\"Central Sulawesi\",\n" +
                "      \"SG\":\"Southeast Sulawesi\",\n" +
                "      \"SA\":\"North Sulawesi\",\n" +
                "      \"SB\":\"West Sumatra\",\n" +
                "      \"SS\":\"South Sumatra\",\n" +
                "      \"SU\":\"North Sumatra\",\n" +
                "      \"YO\":\"Yogyakarta\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"countryCode\": \"KE\",\n" +
                "    \"country\": \"Kenya\",\n" +
                "    \"states\": {\n" +
                "      \"01\":\"Baringo\",\n" +
                "      \"02\":\"Bomet\",\n" +
                "      \"03\":\"Bungoma\",\n" +
                "      \"04\":\"Busia\",\n" +
                "      \"05\":\"Elgeyo/Marakwet\",\n" +
                "      \"06\":\"Embu\",\n" +
                "      \"07\":\"Garissa\",\n" +
                "      \"08\":\"Homa Bay\",\n" +
                "      \"09\":\"Isiolo\",\n" +
                "      \"10\":\"Kajiado\",\n" +
                "      \"11\":\"Kakamega\",\n" +
                "      \"12\":\"Kericho\",\n" +
                "      \"13\":\"Kiambu\",\n" +
                "      \"14\":\"Kilifi\",\n" +
                "      \"15\":\"Kirinyaga\",\n" +
                "      \"16\":\"Kisii\",\n" +
                "      \"17\":\"Kisumu\",\n" +
                "      \"18\":\"Kitui\",\n" +
                "      \"19\":\"Kwale\",\n" +
                "      \"20\":\"Laikipia\",\n" +
                "      \"21\":\"Lamu\",\n" +
                "      \"22\":\"Machakos\",\n" +
                "      \"23\":\"Makueni\",\n" +
                "      \"24\":\"Mandera\",\n" +
                "      \"25\":\"Marsabit\",\n" +
                "      \"26\":\"Meru\",\n" +
                "      \"27\":\"Migori\",\n" +
                "      \"28\":\"Mombasa\",\n" +
                "      \"29\":\"Murang'a\",\n" +
                "      \"30\":\"Nairobi City\",\n" +
                "      \"31\":\"Nakuru\",\n" +
                "      \"32\":\"Nandi\",\n" +
                "      \"33\":\"Narok\",\n" +
                "      \"34\":\"Nyamira\",\n" +
                "      \"35\":\"Nyandarua\",\n" +
                "      \"36\":\"Nyeri\",\n" +
                "      \"37\":\"Samburu\",\n" +
                "      \"38\":\"Siaya\",\n" +
                "      \"39\":\"Taita/Taveta\",\n" +
                "      \"40\":\"Tana River\",\n" +
                "      \"41\":\"Tharaka-Nithi\",\n" +
                "      \"42\":\"Trans Nzoia\",\n" +
                "      \"43\":\"Turkana\",\n" +
                "      \"44\":\"Uasin Gishu\",\n" +
                "      \"45\":\"Vihiga\",\n" +
                "      \"46\":\"Wajir\",\n" +
                "      \"47\":\"West Pokot\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"countryCode\": \"LR\",\n" +
                "    \"country\": \"Liberia\",\n" +
                "    \"states\": {\n" +
                "      \"BM\":\"Bomi\",\n" +
                "      \"BG\":\"Bong\",\n" +
                "      \"GP\":\"Gbarpolu\",\n" +
                "      \"CM\":\"Grand Cape Mount\",\n" +
                "      \"GB\":\"Grand Bassa\",\n" +
                "      \"GG\":\"Grand Gedeh\",\n" +
                "      \"GK\":\"Grand Kru\",\n" +
                "      \"LO\":\"Lofa\",\n" +
                "      \"MG\":\"Margibi\",\n" +
                "      \"MY\":\"Maryland\",\n" +
                "      \"MO\":\"Montserrado\",\n" +
                "      \"NI\":\"Nimba\",\n" +
                "      \"RI\":\"River Cess\",\n" +
                "      \"RG\":\"River Gee\",\n" +
                "      \"SI\":\"Sinoe\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"countryCode\": \"LY\",\n" +
                "    \"country\": \"Libya\",\n" +
                "    \"states\": {\n" +
                "      \"BU\":\"Al Butnan\",\n" +
                "      \"JA\":\"Al Jabal al Akhdar\",\n" +
                "      \"JG\":\"Al Jabal al Gharbi\",\n" +
                "      \"JI\":\"Al Jafarah\",\n" +
                "      \"JU\":\"Al Jufrah\",\n" +
                "      \"KF\":\"Al Kufrah\",\n" +
                "      \"MJ\":\"Al Marj\",\n" +
                "      \"MB\":\"Al Marqab\",\n" +
                "      \"WA\":\"Al Wahat\",\n" +
                "      \"NQ\":\"An Nuqat al Khams\",\n" +
                "      \"ZA\":\"Az Zawiyah\",\n" +
                "      \"BA\":\"Banghazi\",\n" +
                "      \"DR\":\"Darnah\",\n" +
                "      \"GT\":\"Ghat\",\n" +
                "      \"MI\":\"Misratah\",\n" +
                "      \"MQ\":\"Murzuq\",\n" +
                "      \"NL\":\"Nalut\",\n" +
                "      \"SB\":\"Sabha\",\n" +
                "      \"SR\":\"Surt\",\n" +
                "      \"TB\":\"Tarabulus\",\n" +
                "      \"WD\":\"Wadi al Hayat\",\n" +
                "      \"WS\":\"Wadi ash Shatiʾ\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"countryCode\": \"TH\",\n" +
                "    \"country\": \"Thailand\",\n" +
                "    \"states\": {\n" +
                "      \"37\":\"Amnat Charoen\",\n" +
                "      \"15\":\"Ang Thong\",\n" +
                "      \"10\":\"Bangkok\",\n" +
                "      \"38\":\"Bueng Kan\",\n" +
                "      \"31\":\"Buri Ram\",\n" +
                "      \"24\":\"Chachoengsao\",\n" +
                "      \"18\":\"Chai Nat\",\n" +
                "      \"36\":\"Chaiyaphum\",\n" +
                "      \"22\":\"Chanthaburi\",\n" +
                "      \"50\":\"Chiang Mai\",\n" +
                "      \"57\":\"Chiang Rai\",\n" +
                "      \"20\":\"Chon Buri\",\n" +
                "      \"86\":\"Chumphon\",\n" +
                "      \"46\":\"Kalasin\",\n" +
                "      \"62\":\"Kamphaeng Phet\",\n" +
                "      \"71\":\"Kanchanaburi\",\n" +
                "      \"40\":\"Khon Kaen\",\n" +
                "      \"81\":\"Krabi\",\n" +
                "      \"52\":\"Lampang\",\n" +
                "      \"51\":\"Lamphun\",\n" +
                "      \"42\":\"Loei\",\n" +
                "      \"16\":\"Lop Buri\",\n" +
                "      \"58\":\"Mae Hong Son\",\n" +
                "      \"44\":\"Maha Sarakham\",\n" +
                "      \"49\":\"Mukdahan\",\n" +
                "      \"26\":\"Nakhon Nayok\",\n" +
                "      \"73\":\"Nakhon Pathom\",\n" +
                "      \"48\":\"Nakhon Phanom\",\n" +
                "      \"30\":\"Nakhon Ratchasima\",\n" +
                "      \"60\":\"Nakhon Sawan\",\n" +
                "      \"80\":\"Nakhon Si Thammarat\",\n" +
                "      \"55\":\"Nan\",\n" +
                "      \"96\":\"Narathiwat\",\n" +
                "      \"39\":\"Nong Bua Lam Phu\",\n" +
                "      \"43\":\"Nong Khai\",\n" +
                "      \"12\":\"Nonthaburi\",\n" +
                "      \"13\":\"Pathum Thani\",\n" +
                "      \"94\":\"Pattani\",\n" +
                "      \"82\":\"Phangnga\",\n" +
                "      \"93\":\"Phatthalung\",\n" +
                "      \"56\":\"Phayao\",\n" +
                "      \"67\":\"Phetchabun\",\n" +
                "      \"76\":\"Phetchaburi\",\n" +
                "      \"66\":\"Phichit\",\n" +
                "      \"65\":\"Phitsanulok\",\n" +
                "      \"14\":\"Phra Nakhon Si Ayutthaya\",\n" +
                "      \"54\":\"Phrae\",\n" +
                "      \"83\":\"Phuket\",\n" +
                "      \"25\":\"Prachin Buri\",\n" +
                "      \"77\":\"Prachuap Khiri Khan\",\n" +
                "      \"85\":\"Ranong\",\n" +
                "      \"70\":\"Ratchaburi\",\n" +
                "      \"21\":\"Rayong\",\n" +
                "      \"45\":\"Roi Et\",\n" +
                "      \"27\":\"Sa Kaeo\",\n" +
                "      \"47\":\"Sakon Nakhon\",\n" +
                "      \"11\":\"Samut Prakan\",\n" +
                "      \"74\":\"Samut Sakhon\",\n" +
                "      \"75\":\"Samut Songkhram\",\n" +
                "      \"19\":\"Saraburi\",\n" +
                "      \"91\":\"Satun\",\n" +
                "      \"33\":\"Si Sa Ket\",\n" +
                "      \"17\":\"Sing Buri\",\n" +
                "      \"90\":\"Songkhla\",\n" +
                "      \"64\":\"Sukhothai\",\n" +
                "      \"72\":\"Suphan Buri\",\n" +
                "      \"84\":\"Surat Thani\",\n" +
                "      \"32\":\"Surin\",\n" +
                "      \"63\":\"Tak\",\n" +
                "      \"92\":\"Trang\",\n" +
                "      \"23\":\"Trat\",\n" +
                "      \"34\":\"Ubon Ratchathani\",\n" +
                "      \"41\":\"Udon Thani\",\n" +
                "      \"61\":\"Uthai Thani\",\n" +
                "      \"53\":\"Uttaradit\",\n" +
                "      \"95\":\"Yala\",\n" +
                "      \"35\":\"Yasothon\"\n" +
                "    }\n" +
                "  }\n" +
                "]";

        JSONObject finalObj = new JSONObject();
        Map<String, String> countryStateCodeToStateName = new HashMap<>();
        JSONArray jsonArr = new JSONArray(jsonStrData);
//        System.out.println(jsonObj.toString());
        for(int i = 0, len = jsonArr.length(); i < len; i++) {
            JSONObject countryObj = jsonArr.getJSONObject(i);
            String countryCode = countryObj.getString("countryCode");
            JSONObject stateObj = countryObj.getJSONObject("states");
            Iterator<?> keys = stateObj.keys();

            while( keys.hasNext() ) {
                String key = (String)keys.next();
                if ( stateObj.get(key) instanceof JSONObject ) {
                    countryStateCodeToStateName.put(countryCode+"."+key, stateObj.getString(key));
                }
                System.out.println(countryCode+"."+key+" --> "+stateObj.getString(key));
                finalObj.put(countryCode+"."+key, stateObj.getString(key));
            }
        }
        System.out.println(finalObj.toString());

        try {
            Files.write(Paths.get("D:/States.json"), finalObj.toString().getBytes(StandardCharsets.UTF_8));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
