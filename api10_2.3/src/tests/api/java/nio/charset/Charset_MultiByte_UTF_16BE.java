/* Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tests.api.java.nio.charset;

import dalvik.annotation.TestLevel;
import dalvik.annotation.TestTargetClass;
import dalvik.annotation.TestTargetNew;

import junit.framework.TestCase;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;

public class Charset_MultiByte_UTF_16BE extends Charset_AbstractTest {

    @Override
    protected void setUp() throws Exception {
        charsetName = "UTF-16BE";

        testChars = theseChars(new int[]{
0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31,
32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47,
48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63,
64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79,
80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95,
96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111,
112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127,
128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143,
144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159,
160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175,
176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191,
192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207,
208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223,
224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239,
240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255,
256, 296, 336, 376, 416, 456, 496, 536, 576, 616, 656, 696, 736, 776, 816, 856,
896, 936, 976, 1016, 1056, 1096, 1136, 1176, 1216, 1256, 1296, 1336, 1376, 1416, 1456, 1496,
1536, 1576, 1616, 1656, 1696, 1736, 1776, 1816, 1856, 1896, 1936, 1976, 2016, 2056, 2096, 2136,
2176, 2216, 2256, 2296, 2336, 2376, 2416, 2456, 2496, 2536, 2576, 2616, 2656, 2696, 2736, 2776,
2816, 2856, 2896, 2936, 2976, 3016, 3056, 3096, 3136, 3176, 3216, 3256, 3296, 3336, 3376, 3416,
3456, 3496, 3536, 3576, 3616, 3656, 3696, 3736, 3776, 3816, 3856, 3896, 3936, 3976, 4016, 4056,
4096, 4136, 4176, 4216, 4256, 4296, 4336, 4376, 4416, 4456, 4496, 4536, 4576, 4616, 4656, 4696,
4736, 4776, 4816, 4856, 4896, 4936, 4976, 5016, 5056, 5096, 5136, 5176, 5216, 5256, 5296, 5336,
5376, 5416, 5456, 5496, 5536, 5576, 5616, 5656, 5696, 5736, 5776, 5816, 5856, 5896, 5936, 5976,
6016, 6056, 6096, 6136, 6176, 6216, 6256, 6296, 6336, 6376, 6416, 6456, 6496, 6536, 6576, 6616,
6656, 6696, 6736, 6776, 6816, 6856, 6896, 6936, 6976, 7016, 7056, 7096, 7136, 7176, 7216, 7256,
7296, 7336, 7376, 7416, 7456, 7496, 7536, 7576, 7616, 7656, 7696, 7736, 7776, 7816, 7856, 7896,
7936, 7976, 8016, 8056, 8096, 8136, 8176, 8216, 8256, 8296, 8336, 8376, 8416, 8456, 8496, 8536,
8576, 8616, 8656, 8696, 8736, 8776, 8816, 8856, 8896, 8936, 8976, 9016, 9056, 9096, 9136, 9176,
9216, 9256, 9296, 9336, 9376, 9416, 9456, 9496, 9536, 9576, 9616, 9656, 9696, 9736, 9776, 9816,
9856, 9896, 9936, 9976, 10016, 10056, 10096, 10136, 10176, 10216, 10256, 10296, 10336, 10376, 10416, 10456,
10496, 10536, 10576, 10616, 10656, 10696, 10736, 10776, 10816, 10856, 10896, 10936, 10976, 11016, 11056, 11096,
11136, 11176, 11216, 11256, 11296, 11336, 11376, 11416, 11456, 11496, 11536, 11576, 11616, 11656, 11696, 11736,
11776, 11816, 11856, 11896, 11936, 11976, 12016, 12056, 12096, 12136, 12176, 12216, 12256, 12296, 12336, 12376,
12416, 12456, 12496, 12536, 12576, 12616, 12656, 12696, 12736, 12776, 12816, 12856, 12896, 12936, 12976, 13016,
13056, 13096, 13136, 13176, 13216, 13256, 13296, 13336, 13376, 13416, 13456, 13496, 13536, 13576, 13616, 13656,
13696, 13736, 13776, 13816, 13856, 13896, 13936, 13976, 14016, 14056, 14096, 14136, 14176, 14216, 14256, 14296,
14336, 14376, 14416, 14456, 14496, 14536, 14576, 14616, 14656, 14696, 14736, 14776, 14816, 14856, 14896, 14936,
14976, 15016, 15056, 15096, 15136, 15176, 15216, 15256, 15296, 15336, 15376, 15416, 15456, 15496, 15536, 15576,
15616, 15656, 15696, 15736, 15776, 15816, 15856, 15896, 15936, 15976, 16016, 16056, 16096, 16136, 16176, 16216,
16256, 16296, 16336, 16376, 16416, 16456, 16496, 16536, 16576, 16616, 16656, 16696, 16736, 16776, 16816, 16856,
16896, 16936, 16976, 17016, 17056, 17096, 17136, 17176, 17216, 17256, 17296, 17336, 17376, 17416, 17456, 17496,
17536, 17576, 17616, 17656, 17696, 17736, 17776, 17816, 17856, 17896, 17936, 17976, 18016, 18056, 18096, 18136,
18176, 18216, 18256, 18296, 18336, 18376, 18416, 18456, 18496, 18536, 18576, 18616, 18656, 18696, 18736, 18776,
18816, 18856, 18896, 18936, 18976, 19016, 19056, 19096, 19136, 19176, 19216, 19256, 19296, 19336, 19376, 19416,
19456, 19496, 19536, 19576, 19616, 19656, 19696, 19736, 19776, 19816, 19856, 19896, 19936, 19976, 20016, 20056,
20096, 20136, 20176, 20216, 20256, 20296, 20336, 20376, 20416, 20456, 20496, 20536, 20576, 20616, 20656, 20696,
20736, 20776, 20816, 20856, 20896, 20936, 20976, 21016, 21056, 21096, 21136, 21176, 21216, 21256, 21296, 21336,
21376, 21416, 21456, 21496, 21536, 21576, 21616, 21656, 21696, 21736, 21776, 21816, 21856, 21896, 21936, 21976,
22016, 22056, 22096, 22136, 22176, 22216, 22256, 22296, 22336, 22376, 22416, 22456, 22496, 22536, 22576, 22616,
22656, 22696, 22736, 22776, 22816, 22856, 22896, 22936, 22976, 23016, 23056, 23096, 23136, 23176, 23216, 23256,
23296, 23336, 23376, 23416, 23456, 23496, 23536, 23576, 23616, 23656, 23696, 23736, 23776, 23816, 23856, 23896,
23936, 23976, 24016, 24056, 24096, 24136, 24176, 24216, 24256, 24296, 24336, 24376, 24416, 24456, 24496, 24536,
24576, 24616, 24656, 24696, 24736, 24776, 24816, 24856, 24896, 24936, 24976, 25016, 25056, 25096, 25136, 25176,
25216, 25256, 25296, 25336, 25376, 25416, 25456, 25496, 25536, 25576, 25616, 25656, 25696, 25736, 25776, 25816,
25856, 25896, 25936, 25976, 26016, 26056, 26096, 26136, 26176, 26216, 26256, 26296, 26336, 26376, 26416, 26456,
26496, 26536, 26576, 26616, 26656, 26696, 26736, 26776, 26816, 26856, 26896, 26936, 26976, 27016, 27056, 27096,
27136, 27176, 27216, 27256, 27296, 27336, 27376, 27416, 27456, 27496, 27536, 27576, 27616, 27656, 27696, 27736,
27776, 27816, 27856, 27896, 27936, 27976, 28016, 28056, 28096, 28136, 28176, 28216, 28256, 28296, 28336, 28376,
28416, 28456, 28496, 28536, 28576, 28616, 28656, 28696, 28736, 28776, 28816, 28856, 28896, 28936, 28976, 29016,
29056, 29096, 29136, 29176, 29216, 29256, 29296, 29336, 29376, 29416, 29456, 29496, 29536, 29576, 29616, 29656,
29696, 29736, 29776, 29816, 29856, 29896, 29936, 29976, 30016, 30056, 30096, 30136, 30176, 30216, 30256, 30296,
30336, 30376, 30416, 30456, 30496, 30536, 30576, 30616, 30656, 30696, 30736, 30776, 30816, 30856, 30896, 30936,
30976, 31016, 31056, 31096, 31136, 31176, 31216, 31256, 31296, 31336, 31376, 31416, 31456, 31496, 31536, 31576,
31616, 31656, 31696, 31736, 31776, 31816, 31856, 31896, 31936, 31976, 32016, 32056, 32096, 32136, 32176, 32216,
32256, 32296, 32336, 32376, 32416, 32456, 32496, 32536, 32576, 32616, 32656, 32696, 32736, 32776, 32816, 32856,
32896, 32936, 32976, 33016, 33056, 33096, 33136, 33176, 33216, 33256, 33296, 33336, 33376, 33416, 33456, 33496,
33536, 33576, 33616, 33656, 33696, 33736, 33776, 33816, 33856, 33896, 33936, 33976, 34016, 34056, 34096, 34136,
34176, 34216, 34256, 34296, 34336, 34376, 34416, 34456, 34496, 34536, 34576, 34616, 34656, 34696, 34736, 34776,
34816, 34856, 34896, 34936, 34976, 35016, 35056, 35096, 35136, 35176, 35216, 35256, 35296, 35336, 35376, 35416,
35456, 35496, 35536, 35576, 35616, 35656, 35696, 35736, 35776, 35816, 35856, 35896, 35936, 35976, 36016, 36056,
36096, 36136, 36176, 36216, 36256, 36296, 36336, 36376, 36416, 36456, 36496, 36536, 36576, 36616, 36656, 36696,
36736, 36776, 36816, 36856, 36896, 36936, 36976, 37016, 37056, 37096, 37136, 37176, 37216, 37256, 37296, 37336,
37376, 37416, 37456, 37496, 37536, 37576, 37616, 37656, 37696, 37736, 37776, 37816, 37856, 37896, 37936, 37976,
38016, 38056, 38096, 38136, 38176, 38216, 38256, 38296, 38336, 38376, 38416, 38456, 38496, 38536, 38576, 38616,
38656, 38696, 38736, 38776, 38816, 38856, 38896, 38936, 38976, 39016, 39056, 39096, 39136, 39176, 39216, 39256,
39296, 39336, 39376, 39416, 39456, 39496, 39536, 39576, 39616, 39656, 39696, 39736, 39776, 39816, 39856, 39896,
39936, 39976, 40016, 40056, 40096, 40136, 40176, 40216, 40256, 40296, 40336, 40376, 40416, 40456, 40496, 40536,
40576, 40616, 40656, 40696, 40736, 40776, 40816, 40856, 40896, 40936, 40976, 41016, 41056, 41096, 41136, 41176,
41216, 41256, 41296, 41336, 41376, 41416, 41456, 41496, 41536, 41576, 41616, 41656, 41696, 41736, 41776, 41816,
41856, 41896, 41936, 41976, 42016, 42056, 42096, 42136, 42176, 42216, 42256, 42296, 42336, 42376, 42416, 42456,
42496, 42536, 42576, 42616, 42656, 42696, 42736, 42776, 42816, 42856, 42896, 42936, 42976, 43016, 43056, 43096,
43136, 43176, 43216, 43256, 43296, 43336, 43376, 43416, 43456, 43496, 43536, 43576, 43616, 43656, 43696, 43736,
43776, 43816, 43856, 43896, 43936, 43976, 44016, 44056, 44096, 44136, 44176, 44216, 44256, 44296, 44336, 44376,
44416, 44456, 44496, 44536, 44576, 44616, 44656, 44696, 44736, 44776, 44816, 44856, 44896, 44936, 44976, 45016,
45056, 45096, 45136, 45176, 45216, 45256, 45296, 45336, 45376, 45416, 45456, 45496, 45536, 45576, 45616, 45656,
45696, 45736, 45776, 45816, 45856, 45896, 45936, 45976, 46016, 46056, 46096, 46136, 46176, 46216, 46256, 46296,
46336, 46376, 46416, 46456, 46496, 46536, 46576, 46616, 46656, 46696, 46736, 46776, 46816, 46856, 46896, 46936,
46976, 47016, 47056, 47096, 47136, 47176, 47216, 47256, 47296, 47336, 47376, 47416, 47456, 47496, 47536, 47576,
47616, 47656, 47696, 47736, 47776, 47816, 47856, 47896, 47936, 47976, 48016, 48056, 48096, 48136, 48176, 48216,
48256, 48296, 48336, 48376, 48416, 48456, 48496, 48536, 48576, 48616, 48656, 48696, 48736, 48776, 48816, 48856,
48896, 48936, 48976, 49016, 49056, 49096, 49136, 49176, 49216, 49256, 49296, 49336, 49376, 49416, 49456, 49496,
49536, 49576, 49616, 49656, 49696, 49736, 49776, 49816, 49856, 49896, 49936, 49976, 50016, 50056, 50096, 50136,
50176, 50216, 50256, 50296, 50336, 50376, 50416, 50456, 50496, 50536, 50576, 50616, 50656, 50696, 50736, 50776,
50816, 50856, 50896, 50936, 50976, 51016, 51056, 51096, 51136, 51176, 51216, 51256, 51296, 51336, 51376, 51416,
51456, 51496, 51536, 51576, 51616, 51656, 51696, 51736, 51776, 51816, 51856, 51896, 51936, 51976, 52016, 52056,
52096, 52136, 52176, 52216, 52256, 52296, 52336, 52376, 52416, 52456, 52496, 52536, 52576, 52616, 52656, 52696,
52736, 52776, 52816, 52856, 52896, 52936, 52976, 53016, 53056, 53096, 53136, 53176, 53216, 53256, 53296, 53336,
53376, 53416, 53456, 53496, 53536, 53576, 53616, 53656, 53696, 53736, 53776, 53816, 53856, 53896, 53936, 53976,
54016, 54056, 54096, 54136, 54176, 54216, 54256, 54296, 54336, 54376, 54416, 54456, 54496, 54536, 54576, 54616,
54656, 54696, 54736, 54776, 54816, 54856, 54896, 54936, 54976, 55016, 55056, 55096, 55136, 55176, 55216, 55256,
57344, 57384, 57424, 57464, 57504, 57544, 57584, 57624, 57664, 57704, 57744, 57784, 57824, 57864, 57904, 57944,
57984, 58024, 58064, 58104, 58144, 58184, 58224, 58264, 58304, 58344, 58384, 58424, 58464, 58504, 58544, 58584,
58624, 58664, 58704, 58744, 58784, 58824, 58864, 58904, 58944, 58984, 59024, 59064, 59104, 59144, 59184, 59224,
59264, 59304, 59344, 59384, 59424, 59464, 59504, 59544, 59584, 59624, 59664, 59704, 59744, 59784, 59824, 59864,
59904, 59944, 59984, 60024, 60064, 60104, 60144, 60184, 60224, 60264, 60304, 60344, 60384, 60424, 60464, 60504,
60544, 60584, 60624, 60664, 60704, 60744, 60784, 60824, 60864, 60904, 60944, 60984, 61024, 61064, 61104, 61144,
61184, 61224, 61264, 61304, 61344, 61384, 61424, 61464, 61504, 61544, 61584, 61624, 61664, 61704, 61744, 61784,
61824, 61864, 61904, 61944, 61984, 62024, 62064, 62104, 62144, 62184, 62224, 62264, 62304, 62344, 62384, 62424,
62464, 62504, 62544, 62584, 62624, 62664, 62704, 62744, 62784, 62824, 62864, 62904, 62944, 62984, 63024, 63064,
63104, 63144, 63184, 63224, 63264, 63304, 63344, 63384, 63424, 63464, 63504, 63544, 63584, 63624, 63664, 63704,
63744, 63784, 63824, 63864, 63904, 63944, 63984, 64024, 64064, 64104, 64144, 64184, 64224, 64264, 64304, 64344,
64384, 64424, 64464, 64504, 64544, 64584, 64624, 64664, 64704, 64744, 64784, 64824, 64864, 64904, 64944, 64984,
65024, 65064, 65104, 65144, 65184, 65224, 65264, 65304, 65344, 65384, 65424, 65464, 65504
            });

        testBytes = theseBytes(new int[]{
0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6, 0, 7,
0, 8, 0, 9, 0, 10, 0, 11, 0, 12, 0, 13, 0, 14, 0, 15,
0, 16, 0, 17, 0, 18, 0, 19, 0, 20, 0, 21, 0, 22, 0, 23,
0, 24, 0, 25, 0, 26, 0, 27, 0, 28, 0, 29, 0, 30, 0, 31,
0, 32, 0, 33, 0, 34, 0, 35, 0, 36, 0, 37, 0, 38, 0, 39,
0, 40, 0, 41, 0, 42, 0, 43, 0, 44, 0, 45, 0, 46, 0, 47,
0, 48, 0, 49, 0, 50, 0, 51, 0, 52, 0, 53, 0, 54, 0, 55,
0, 56, 0, 57, 0, 58, 0, 59, 0, 60, 0, 61, 0, 62, 0, 63,
0, 64, 0, 65, 0, 66, 0, 67, 0, 68, 0, 69, 0, 70, 0, 71,
0, 72, 0, 73, 0, 74, 0, 75, 0, 76, 0, 77, 0, 78, 0, 79,
0, 80, 0, 81, 0, 82, 0, 83, 0, 84, 0, 85, 0, 86, 0, 87,
0, 88, 0, 89, 0, 90, 0, 91, 0, 92, 0, 93, 0, 94, 0, 95,
0, 96, 0, 97, 0, 98, 0, 99, 0, 100, 0, 101, 0, 102, 0, 103,
0, 104, 0, 105, 0, 106, 0, 107, 0, 108, 0, 109, 0, 110, 0, 111,
0, 112, 0, 113, 0, 114, 0, 115, 0, 116, 0, 117, 0, 118, 0, 119,
0, 120, 0, 121, 0, 122, 0, 123, 0, 124, 0, 125, 0, 126, 0, 127,
0, 128, 0, 129, 0, 130, 0, 131, 0, 132, 0, 133, 0, 134, 0, 135,
0, 136, 0, 137, 0, 138, 0, 139, 0, 140, 0, 141, 0, 142, 0, 143,
0, 144, 0, 145, 0, 146, 0, 147, 0, 148, 0, 149, 0, 150, 0, 151,
0, 152, 0, 153, 0, 154, 0, 155, 0, 156, 0, 157, 0, 158, 0, 159,
0, 160, 0, 161, 0, 162, 0, 163, 0, 164, 0, 165, 0, 166, 0, 167,
0, 168, 0, 169, 0, 170, 0, 171, 0, 172, 0, 173, 0, 174, 0, 175,
0, 176, 0, 177, 0, 178, 0, 179, 0, 180, 0, 181, 0, 182, 0, 183,
0, 184, 0, 185, 0, 186, 0, 187, 0, 188, 0, 189, 0, 190, 0, 191,
0, 192, 0, 193, 0, 194, 0, 195, 0, 196, 0, 197, 0, 198, 0, 199,
0, 200, 0, 201, 0, 202, 0, 203, 0, 204, 0, 205, 0, 206, 0, 207,
0, 208, 0, 209, 0, 210, 0, 211, 0, 212, 0, 213, 0, 214, 0, 215,
0, 216, 0, 217, 0, 218, 0, 219, 0, 220, 0, 221, 0, 222, 0, 223,
0, 224, 0, 225, 0, 226, 0, 227, 0, 228, 0, 229, 0, 230, 0, 231,
0, 232, 0, 233, 0, 234, 0, 235, 0, 236, 0, 237, 0, 238, 0, 239,
0, 240, 0, 241, 0, 242, 0, 243, 0, 244, 0, 245, 0, 246, 0, 247,
0, 248, 0, 249, 0, 250, 0, 251, 0, 252, 0, 253, 0, 254, 0, 255,
1, 0, 1, 40, 1, 80, 1, 120, 1, 160, 1, 200, 1, 240, 2, 24,
2, 64, 2, 104, 2, 144, 2, 184, 2, 224, 3, 8, 3, 48, 3, 88,
3, 128, 3, 168, 3, 208, 3, 248, 4, 32, 4, 72, 4, 112, 4, 152,
4, 192, 4, 232, 5, 16, 5, 56, 5, 96, 5, 136, 5, 176, 5, 216,
6, 0, 6, 40, 6, 80, 6, 120, 6, 160, 6, 200, 6, 240, 7, 24,
7, 64, 7, 104, 7, 144, 7, 184, 7, 224, 8, 8, 8, 48, 8, 88,
8, 128, 8, 168, 8, 208, 8, 248, 9, 32, 9, 72, 9, 112, 9, 152,
9, 192, 9, 232, 10, 16, 10, 56, 10, 96, 10, 136, 10, 176, 10, 216,
11, 0, 11, 40, 11, 80, 11, 120, 11, 160, 11, 200, 11, 240, 12, 24,
12, 64, 12, 104, 12, 144, 12, 184, 12, 224, 13, 8, 13, 48, 13, 88,
13, 128, 13, 168, 13, 208, 13, 248, 14, 32, 14, 72, 14, 112, 14, 152,
14, 192, 14, 232, 15, 16, 15, 56, 15, 96, 15, 136, 15, 176, 15, 216,
16, 0, 16, 40, 16, 80, 16, 120, 16, 160, 16, 200, 16, 240, 17, 24,
17, 64, 17, 104, 17, 144, 17, 184, 17, 224, 18, 8, 18, 48, 18, 88,
18, 128, 18, 168, 18, 208, 18, 248, 19, 32, 19, 72, 19, 112, 19, 152,
19, 192, 19, 232, 20, 16, 20, 56, 20, 96, 20, 136, 20, 176, 20, 216,
21, 0, 21, 40, 21, 80, 21, 120, 21, 160, 21, 200, 21, 240, 22, 24,
22, 64, 22, 104, 22, 144, 22, 184, 22, 224, 23, 8, 23, 48, 23, 88,
23, 128, 23, 168, 23, 208, 23, 248, 24, 32, 24, 72, 24, 112, 24, 152,
24, 192, 24, 232, 25, 16, 25, 56, 25, 96, 25, 136, 25, 176, 25, 216,
26, 0, 26, 40, 26, 80, 26, 120, 26, 160, 26, 200, 26, 240, 27, 24,
27, 64, 27, 104, 27, 144, 27, 184, 27, 224, 28, 8, 28, 48, 28, 88,
28, 128, 28, 168, 28, 208, 28, 248, 29, 32, 29, 72, 29, 112, 29, 152,
29, 192, 29, 232, 30, 16, 30, 56, 30, 96, 30, 136, 30, 176, 30, 216,
31, 0, 31, 40, 31, 80, 31, 120, 31, 160, 31, 200, 31, 240, 32, 24,
32, 64, 32, 104, 32, 144, 32, 184, 32, 224, 33, 8, 33, 48, 33, 88,
33, 128, 33, 168, 33, 208, 33, 248, 34, 32, 34, 72, 34, 112, 34, 152,
34, 192, 34, 232, 35, 16, 35, 56, 35, 96, 35, 136, 35, 176, 35, 216,
36, 0, 36, 40, 36, 80, 36, 120, 36, 160, 36, 200, 36, 240, 37, 24,
37, 64, 37, 104, 37, 144, 37, 184, 37, 224, 38, 8, 38, 48, 38, 88,
38, 128, 38, 168, 38, 208, 38, 248, 39, 32, 39, 72, 39, 112, 39, 152,
39, 192, 39, 232, 40, 16, 40, 56, 40, 96, 40, 136, 40, 176, 40, 216,
41, 0, 41, 40, 41, 80, 41, 120, 41, 160, 41, 200, 41, 240, 42, 24,
42, 64, 42, 104, 42, 144, 42, 184, 42, 224, 43, 8, 43, 48, 43, 88,
43, 128, 43, 168, 43, 208, 43, 248, 44, 32, 44, 72, 44, 112, 44, 152,
44, 192, 44, 232, 45, 16, 45, 56, 45, 96, 45, 136, 45, 176, 45, 216,
46, 0, 46, 40, 46, 80, 46, 120, 46, 160, 46, 200, 46, 240, 47, 24,
47, 64, 47, 104, 47, 144, 47, 184, 47, 224, 48, 8, 48, 48, 48, 88,
48, 128, 48, 168, 48, 208, 48, 248, 49, 32, 49, 72, 49, 112, 49, 152,
49, 192, 49, 232, 50, 16, 50, 56, 50, 96, 50, 136, 50, 176, 50, 216,
51, 0, 51, 40, 51, 80, 51, 120, 51, 160, 51, 200, 51, 240, 52, 24,
52, 64, 52, 104, 52, 144, 52, 184, 52, 224, 53, 8, 53, 48, 53, 88,
53, 128, 53, 168, 53, 208, 53, 248, 54, 32, 54, 72, 54, 112, 54, 152,
54, 192, 54, 232, 55, 16, 55, 56, 55, 96, 55, 136, 55, 176, 55, 216,
56, 0, 56, 40, 56, 80, 56, 120, 56, 160, 56, 200, 56, 240, 57, 24,
57, 64, 57, 104, 57, 144, 57, 184, 57, 224, 58, 8, 58, 48, 58, 88,
58, 128, 58, 168, 58, 208, 58, 248, 59, 32, 59, 72, 59, 112, 59, 152,
59, 192, 59, 232, 60, 16, 60, 56, 60, 96, 60, 136, 60, 176, 60, 216,
61, 0, 61, 40, 61, 80, 61, 120, 61, 160, 61, 200, 61, 240, 62, 24,
62, 64, 62, 104, 62, 144, 62, 184, 62, 224, 63, 8, 63, 48, 63, 88,
63, 128, 63, 168, 63, 208, 63, 248, 64, 32, 64, 72, 64, 112, 64, 152,
64, 192, 64, 232, 65, 16, 65, 56, 65, 96, 65, 136, 65, 176, 65, 216,
66, 0, 66, 40, 66, 80, 66, 120, 66, 160, 66, 200, 66, 240, 67, 24,
67, 64, 67, 104, 67, 144, 67, 184, 67, 224, 68, 8, 68, 48, 68, 88,
68, 128, 68, 168, 68, 208, 68, 248, 69, 32, 69, 72, 69, 112, 69, 152,
69, 192, 69, 232, 70, 16, 70, 56, 70, 96, 70, 136, 70, 176, 70, 216,
71, 0, 71, 40, 71, 80, 71, 120, 71, 160, 71, 200, 71, 240, 72, 24,
72, 64, 72, 104, 72, 144, 72, 184, 72, 224, 73, 8, 73, 48, 73, 88,
73, 128, 73, 168, 73, 208, 73, 248, 74, 32, 74, 72, 74, 112, 74, 152,
74, 192, 74, 232, 75, 16, 75, 56, 75, 96, 75, 136, 75, 176, 75, 216,
76, 0, 76, 40, 76, 80, 76, 120, 76, 160, 76, 200, 76, 240, 77, 24,
77, 64, 77, 104, 77, 144, 77, 184, 77, 224, 78, 8, 78, 48, 78, 88,
78, 128, 78, 168, 78, 208, 78, 248, 79, 32, 79, 72, 79, 112, 79, 152,
79, 192, 79, 232, 80, 16, 80, 56, 80, 96, 80, 136, 80, 176, 80, 216,
81, 0, 81, 40, 81, 80, 81, 120, 81, 160, 81, 200, 81, 240, 82, 24,
82, 64, 82, 104, 82, 144, 82, 184, 82, 224, 83, 8, 83, 48, 83, 88,
83, 128, 83, 168, 83, 208, 83, 248, 84, 32, 84, 72, 84, 112, 84, 152,
84, 192, 84, 232, 85, 16, 85, 56, 85, 96, 85, 136, 85, 176, 85, 216,
86, 0, 86, 40, 86, 80, 86, 120, 86, 160, 86, 200, 86, 240, 87, 24,
87, 64, 87, 104, 87, 144, 87, 184, 87, 224, 88, 8, 88, 48, 88, 88,
88, 128, 88, 168, 88, 208, 88, 248, 89, 32, 89, 72, 89, 112, 89, 152,
89, 192, 89, 232, 90, 16, 90, 56, 90, 96, 90, 136, 90, 176, 90, 216,
91, 0, 91, 40, 91, 80, 91, 120, 91, 160, 91, 200, 91, 240, 92, 24,
92, 64, 92, 104, 92, 144, 92, 184, 92, 224, 93, 8, 93, 48, 93, 88,
93, 128, 93, 168, 93, 208, 93, 248, 94, 32, 94, 72, 94, 112, 94, 152,
94, 192, 94, 232, 95, 16, 95, 56, 95, 96, 95, 136, 95, 176, 95, 216,
96, 0, 96, 40, 96, 80, 96, 120, 96, 160, 96, 200, 96, 240, 97, 24,
97, 64, 97, 104, 97, 144, 97, 184, 97, 224, 98, 8, 98, 48, 98, 88,
98, 128, 98, 168, 98, 208, 98, 248, 99, 32, 99, 72, 99, 112, 99, 152,
99, 192, 99, 232, 100, 16, 100, 56, 100, 96, 100, 136, 100, 176, 100, 216,
101, 0, 101, 40, 101, 80, 101, 120, 101, 160, 101, 200, 101, 240, 102, 24,
102, 64, 102, 104, 102, 144, 102, 184, 102, 224, 103, 8, 103, 48, 103, 88,
103, 128, 103, 168, 103, 208, 103, 248, 104, 32, 104, 72, 104, 112, 104, 152,
104, 192, 104, 232, 105, 16, 105, 56, 105, 96, 105, 136, 105, 176, 105, 216,
106, 0, 106, 40, 106, 80, 106, 120, 106, 160, 106, 200, 106, 240, 107, 24,
107, 64, 107, 104, 107, 144, 107, 184, 107, 224, 108, 8, 108, 48, 108, 88,
108, 128, 108, 168, 108, 208, 108, 248, 109, 32, 109, 72, 109, 112, 109, 152,
109, 192, 109, 232, 110, 16, 110, 56, 110, 96, 110, 136, 110, 176, 110, 216,
111, 0, 111, 40, 111, 80, 111, 120, 111, 160, 111, 200, 111, 240, 112, 24,
112, 64, 112, 104, 112, 144, 112, 184, 112, 224, 113, 8, 113, 48, 113, 88,
113, 128, 113, 168, 113, 208, 113, 248, 114, 32, 114, 72, 114, 112, 114, 152,
114, 192, 114, 232, 115, 16, 115, 56, 115, 96, 115, 136, 115, 176, 115, 216,
116, 0, 116, 40, 116, 80, 116, 120, 116, 160, 116, 200, 116, 240, 117, 24,
117, 64, 117, 104, 117, 144, 117, 184, 117, 224, 118, 8, 118, 48, 118, 88,
118, 128, 118, 168, 118, 208, 118, 248, 119, 32, 119, 72, 119, 112, 119, 152,
119, 192, 119, 232, 120, 16, 120, 56, 120, 96, 120, 136, 120, 176, 120, 216,
121, 0, 121, 40, 121, 80, 121, 120, 121, 160, 121, 200, 121, 240, 122, 24,
122, 64, 122, 104, 122, 144, 122, 184, 122, 224, 123, 8, 123, 48, 123, 88,
123, 128, 123, 168, 123, 208, 123, 248, 124, 32, 124, 72, 124, 112, 124, 152,
124, 192, 124, 232, 125, 16, 125, 56, 125, 96, 125, 136, 125, 176, 125, 216,
126, 0, 126, 40, 126, 80, 126, 120, 126, 160, 126, 200, 126, 240, 127, 24,
127, 64, 127, 104, 127, 144, 127, 184, 127, 224, 128, 8, 128, 48, 128, 88,
128, 128, 128, 168, 128, 208, 128, 248, 129, 32, 129, 72, 129, 112, 129, 152,
129, 192, 129, 232, 130, 16, 130, 56, 130, 96, 130, 136, 130, 176, 130, 216,
131, 0, 131, 40, 131, 80, 131, 120, 131, 160, 131, 200, 131, 240, 132, 24,
132, 64, 132, 104, 132, 144, 132, 184, 132, 224, 133, 8, 133, 48, 133, 88,
133, 128, 133, 168, 133, 208, 133, 248, 134, 32, 134, 72, 134, 112, 134, 152,
134, 192, 134, 232, 135, 16, 135, 56, 135, 96, 135, 136, 135, 176, 135, 216,
136, 0, 136, 40, 136, 80, 136, 120, 136, 160, 136, 200, 136, 240, 137, 24,
137, 64, 137, 104, 137, 144, 137, 184, 137, 224, 138, 8, 138, 48, 138, 88,
138, 128, 138, 168, 138, 208, 138, 248, 139, 32, 139, 72, 139, 112, 139, 152,
139, 192, 139, 232, 140, 16, 140, 56, 140, 96, 140, 136, 140, 176, 140, 216,
141, 0, 141, 40, 141, 80, 141, 120, 141, 160, 141, 200, 141, 240, 142, 24,
142, 64, 142, 104, 142, 144, 142, 184, 142, 224, 143, 8, 143, 48, 143, 88,
143, 128, 143, 168, 143, 208, 143, 248, 144, 32, 144, 72, 144, 112, 144, 152,
144, 192, 144, 232, 145, 16, 145, 56, 145, 96, 145, 136, 145, 176, 145, 216,
146, 0, 146, 40, 146, 80, 146, 120, 146, 160, 146, 200, 146, 240, 147, 24,
147, 64, 147, 104, 147, 144, 147, 184, 147, 224, 148, 8, 148, 48, 148, 88,
148, 128, 148, 168, 148, 208, 148, 248, 149, 32, 149, 72, 149, 112, 149, 152,
149, 192, 149, 232, 150, 16, 150, 56, 150, 96, 150, 136, 150, 176, 150, 216,
151, 0, 151, 40, 151, 80, 151, 120, 151, 160, 151, 200, 151, 240, 152, 24,
152, 64, 152, 104, 152, 144, 152, 184, 152, 224, 153, 8, 153, 48, 153, 88,
153, 128, 153, 168, 153, 208, 153, 248, 154, 32, 154, 72, 154, 112, 154, 152,
154, 192, 154, 232, 155, 16, 155, 56, 155, 96, 155, 136, 155, 176, 155, 216,
156, 0, 156, 40, 156, 80, 156, 120, 156, 160, 156, 200, 156, 240, 157, 24,
157, 64, 157, 104, 157, 144, 157, 184, 157, 224, 158, 8, 158, 48, 158, 88,
158, 128, 158, 168, 158, 208, 158, 248, 159, 32, 159, 72, 159, 112, 159, 152,
159, 192, 159, 232, 160, 16, 160, 56, 160, 96, 160, 136, 160, 176, 160, 216,
161, 0, 161, 40, 161, 80, 161, 120, 161, 160, 161, 200, 161, 240, 162, 24,
162, 64, 162, 104, 162, 144, 162, 184, 162, 224, 163, 8, 163, 48, 163, 88,
163, 128, 163, 168, 163, 208, 163, 248, 164, 32, 164, 72, 164, 112, 164, 152,
164, 192, 164, 232, 165, 16, 165, 56, 165, 96, 165, 136, 165, 176, 165, 216,
166, 0, 166, 40, 166, 80, 166, 120, 166, 160, 166, 200, 166, 240, 167, 24,
167, 64, 167, 104, 167, 144, 167, 184, 167, 224, 168, 8, 168, 48, 168, 88,
168, 128, 168, 168, 168, 208, 168, 248, 169, 32, 169, 72, 169, 112, 169, 152,
169, 192, 169, 232, 170, 16, 170, 56, 170, 96, 170, 136, 170, 176, 170, 216,
171, 0, 171, 40, 171, 80, 171, 120, 171, 160, 171, 200, 171, 240, 172, 24,
172, 64, 172, 104, 172, 144, 172, 184, 172, 224, 173, 8, 173, 48, 173, 88,
173, 128, 173, 168, 173, 208, 173, 248, 174, 32, 174, 72, 174, 112, 174, 152,
174, 192, 174, 232, 175, 16, 175, 56, 175, 96, 175, 136, 175, 176, 175, 216,
176, 0, 176, 40, 176, 80, 176, 120, 176, 160, 176, 200, 176, 240, 177, 24,
177, 64, 177, 104, 177, 144, 177, 184, 177, 224, 178, 8, 178, 48, 178, 88,
178, 128, 178, 168, 178, 208, 178, 248, 179, 32, 179, 72, 179, 112, 179, 152,
179, 192, 179, 232, 180, 16, 180, 56, 180, 96, 180, 136, 180, 176, 180, 216,
181, 0, 181, 40, 181, 80, 181, 120, 181, 160, 181, 200, 181, 240, 182, 24,
182, 64, 182, 104, 182, 144, 182, 184, 182, 224, 183, 8, 183, 48, 183, 88,
183, 128, 183, 168, 183, 208, 183, 248, 184, 32, 184, 72, 184, 112, 184, 152,
184, 192, 184, 232, 185, 16, 185, 56, 185, 96, 185, 136, 185, 176, 185, 216,
186, 0, 186, 40, 186, 80, 186, 120, 186, 160, 186, 200, 186, 240, 187, 24,
187, 64, 187, 104, 187, 144, 187, 184, 187, 224, 188, 8, 188, 48, 188, 88,
188, 128, 188, 168, 188, 208, 188, 248, 189, 32, 189, 72, 189, 112, 189, 152,
189, 192, 189, 232, 190, 16, 190, 56, 190, 96, 190, 136, 190, 176, 190, 216,
191, 0, 191, 40, 191, 80, 191, 120, 191, 160, 191, 200, 191, 240, 192, 24,
192, 64, 192, 104, 192, 144, 192, 184, 192, 224, 193, 8, 193, 48, 193, 88,
193, 128, 193, 168, 193, 208, 193, 248, 194, 32, 194, 72, 194, 112, 194, 152,
194, 192, 194, 232, 195, 16, 195, 56, 195, 96, 195, 136, 195, 176, 195, 216,
196, 0, 196, 40, 196, 80, 196, 120, 196, 160, 196, 200, 196, 240, 197, 24,
197, 64, 197, 104, 197, 144, 197, 184, 197, 224, 198, 8, 198, 48, 198, 88,
198, 128, 198, 168, 198, 208, 198, 248, 199, 32, 199, 72, 199, 112, 199, 152,
199, 192, 199, 232, 200, 16, 200, 56, 200, 96, 200, 136, 200, 176, 200, 216,
201, 0, 201, 40, 201, 80, 201, 120, 201, 160, 201, 200, 201, 240, 202, 24,
202, 64, 202, 104, 202, 144, 202, 184, 202, 224, 203, 8, 203, 48, 203, 88,
203, 128, 203, 168, 203, 208, 203, 248, 204, 32, 204, 72, 204, 112, 204, 152,
204, 192, 204, 232, 205, 16, 205, 56, 205, 96, 205, 136, 205, 176, 205, 216,
206, 0, 206, 40, 206, 80, 206, 120, 206, 160, 206, 200, 206, 240, 207, 24,
207, 64, 207, 104, 207, 144, 207, 184, 207, 224, 208, 8, 208, 48, 208, 88,
208, 128, 208, 168, 208, 208, 208, 248, 209, 32, 209, 72, 209, 112, 209, 152,
209, 192, 209, 232, 210, 16, 210, 56, 210, 96, 210, 136, 210, 176, 210, 216,
211, 0, 211, 40, 211, 80, 211, 120, 211, 160, 211, 200, 211, 240, 212, 24,
212, 64, 212, 104, 212, 144, 212, 184, 212, 224, 213, 8, 213, 48, 213, 88,
213, 128, 213, 168, 213, 208, 213, 248, 214, 32, 214, 72, 214, 112, 214, 152,
214, 192, 214, 232, 215, 16, 215, 56, 215, 96, 215, 136, 215, 176, 215, 216,
224, 0, 224, 40, 224, 80, 224, 120, 224, 160, 224, 200, 224, 240, 225, 24,
225, 64, 225, 104, 225, 144, 225, 184, 225, 224, 226, 8, 226, 48, 226, 88,
226, 128, 226, 168, 226, 208, 226, 248, 227, 32, 227, 72, 227, 112, 227, 152,
227, 192, 227, 232, 228, 16, 228, 56, 228, 96, 228, 136, 228, 176, 228, 216,
229, 0, 229, 40, 229, 80, 229, 120, 229, 160, 229, 200, 229, 240, 230, 24,
230, 64, 230, 104, 230, 144, 230, 184, 230, 224, 231, 8, 231, 48, 231, 88,
231, 128, 231, 168, 231, 208, 231, 248, 232, 32, 232, 72, 232, 112, 232, 152,
232, 192, 232, 232, 233, 16, 233, 56, 233, 96, 233, 136, 233, 176, 233, 216,
234, 0, 234, 40, 234, 80, 234, 120, 234, 160, 234, 200, 234, 240, 235, 24,
235, 64, 235, 104, 235, 144, 235, 184, 235, 224, 236, 8, 236, 48, 236, 88,
236, 128, 236, 168, 236, 208, 236, 248, 237, 32, 237, 72, 237, 112, 237, 152,
237, 192, 237, 232, 238, 16, 238, 56, 238, 96, 238, 136, 238, 176, 238, 216,
239, 0, 239, 40, 239, 80, 239, 120, 239, 160, 239, 200, 239, 240, 240, 24,
240, 64, 240, 104, 240, 144, 240, 184, 240, 224, 241, 8, 241, 48, 241, 88,
241, 128, 241, 168, 241, 208, 241, 248, 242, 32, 242, 72, 242, 112, 242, 152,
242, 192, 242, 232, 243, 16, 243, 56, 243, 96, 243, 136, 243, 176, 243, 216,
244, 0, 244, 40, 244, 80, 244, 120, 244, 160, 244, 200, 244, 240, 245, 24,
245, 64, 245, 104, 245, 144, 245, 184, 245, 224, 246, 8, 246, 48, 246, 88,
246, 128, 246, 168, 246, 208, 246, 248, 247, 32, 247, 72, 247, 112, 247, 152,
247, 192, 247, 232, 248, 16, 248, 56, 248, 96, 248, 136, 248, 176, 248, 216,
249, 0, 249, 40, 249, 80, 249, 120, 249, 160, 249, 200, 249, 240, 250, 24,
250, 64, 250, 104, 250, 144, 250, 184, 250, 224, 251, 8, 251, 48, 251, 88,
251, 128, 251, 168, 251, 208, 251, 248, 252, 32, 252, 72, 252, 112, 252, 152,
252, 192, 252, 232, 253, 16, 253, 56, 253, 96, 253, 136, 253, 176, 253, 216,
254, 0, 254, 40, 254, 80, 254, 120, 254, 160, 254, 200, 254, 240, 255, 24,
255, 64, 255, 104, 255, 144, 255, 184, 255, 224
            });

        super.setUp();
    }

}
