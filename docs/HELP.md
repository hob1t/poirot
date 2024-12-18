# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.4/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.4/gradle-plugin/packaging-oci-image.html)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#data.nosql.mongodb)

#### Useful commands

##### Install MongoDB locally

```bash
cd scripts
docker-compose up -d
```

##### Show available java versions

Minimum java version is Java 17.

```bash
/usr/libexec/java_home -V
```

#### Docker

* Be sure that Docker Desktop is up and running together with docker

Check if docker is up and running

``` bash
docker ps 
```

#### Swagger

[run me](http://localhost:9090/swagger-ui/index.html)


### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)

### Additional Links

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

##### LI structure we get during the scrapping

```json
{
  "@context":"http://schema.org",
  "@graph":[
    {
      "@type":"Person",
      "address":{
        "@type":"PostalAddress",
        "addressLocality":"Denver, Colorado, United States",
        "addressCountry":"US"
      },
      "alumniOf":[
        {
          "@type":"EducationalOrganization",
          "name":"Texas A&M University",
          "url":"https://www.linkedin.com/school/texas-a&m-university/",
          "member":{
            "@type":"OrganizationRole",
            "startDate":1993,
            "endDate":1998
          }
        }
      ],
      "awards":[
        "Chief Data Officer Magazine - Leading Data Consultants",
        "Epicor Innovation Award"
      ],
      "image":{
        "@type":"ImageObject",
        "contentUrl":"https://media.licdn.com/dms/image/v2/D5603AQGNj73gyg8EyQ/profile-displayphoto-shrink_200_200/profile-displayphoto-shrink_200_200/0/1693333951210?e=2147483647&v=beta&t=g02i2msMkmv6m0YwhWaGmwyCtKUGx8cDnlo9GDlsKkI"
      },
      "jobTitle":[
        "********* **** *********",
        "******* *******, ******** ******* ",
        "**. ********, ******** *******",
        "**** *********, ****** ******** *******, ****-****",
        "**. ********, ****** ******** *******, ******* **** ********** **********",
        "********, ******** & ******* **********",
        "********, ************ ******** ******** & **********",
        "********, ******** ********** ********",
        "**. *******, ******** ********** ********",
        "**. *******, ******** ********** ********",
        "************** *******, ********* ********",
        "**. ******* *******, ********* ********",
        "********* ***** **************"
      ],
      "name":"Jon Snow",
      "sameAs":"https://www.linkedin.com/in/jonwsnow",
      "url":"https://www.linkedin.com/in/jonwsnow",
      "memberOf":[

      ],
      "worksFor":[
        {
          "@type":"Organization",
          "name":"Icertis",
          "url":"https://www.linkedin.com/company/icertis",
          "location":"Denver, Colorado, United States",
          "member":{
            "@type":"OrganizationRole",
            "description":"• *** ******** ******* ******** *** ********** *** ********* ********* ** *** ********.\u003C**\u003E• ********* ******** ** ******** ******** ***** *** ****** ******** ************* *** ******** ********* *******.\u003C**\u003E• ******** *********** ******* ****** *** ******** ************ ******* ********* ******** ******* ***********."
          }
        },
        {
          "@type":"Organization",
          "name":"*******",
          "location":"Denver, Colorado, United States",
          "member":{
            "@type":"OrganizationRole",
            "description":"• *********** *** ************* ** *** ******** ******* ************ ** *******, ******* ******** ******** *** ***** *********** *** ****** *********.\u003C**\u003E• ************ **** *****-********** ***** ** ****** *********** ******** ********** *** ******* ******.\u003C**\u003E• *********** ********** ** ******* *******' ***** ****** ********** *** ******* ***********."
          }
        },
        {
          "@type":"Organization",
          "name":"****",
          "location":"Denver, Colorado, United States",
          "member":{
            "@type":"OrganizationRole",
            "description":"******* ******** ******* *** ******* ***** ** *** ********.\u003C**\u003E******* ******** ******** **** * ***** ** **** ** ***** *********, ******* ********** *********' ****** ** **********."
          }
        },
        {
          "@type":"Organization",
          "name":"***** *",
          "location":"Denver, CO",
          "member":{
            "@type":"OrganizationRole",
            "description":"•\t******* *** ************ ******** *** ******** ******* ***** *** *** ****-**** *********\u003C**\u003E•\t********* ******* **** ********** ********** ********** ****\u003C**\u003E•\t******* ** ******* ********** ******* ******** *** ********* ************ ** *************** ** ******* ******** ************ \u003C**\u003E•\t******* *** ***** * *** ******** ***** *******\u003C**\u003E\u003C**\u003E*************:\u003C**\u003E•\t*** ******** ***** **-***** *********** **** -** ** +**.\u003C**\u003E•\t**% ******* *********** ** *****-****** **** *********** *&*.\u003C**\u003E•\t**% ****** *********** ** *****-****** **** *********** *&*.\u003C**\u003E•\t**.*% ****** ********* ******* ********* **** (******** *******)."
          }
        },
        {
          "@type":"Organization",
          "name":"***** *",
          "location":"Denver, CO",
          "member":{
            "@type":"OrganizationRole",
            "description":"•\t******* ******** *** ******* ****** ***** *** ******* **** **********, *********:  **************, *******, ******* **********, ******** *******, *** *********.\u003C**\u003E•\t******* ******** ********* *** ******** *** ********* ** ***** ******** ******** ********.\u003C**\u003E•\t***** ********* *** ******** ******* ********** ****** *** ***** * ******** *** *********.\u003C**\u003E\u003C**\u003E*************:\u003C**\u003E•\t***** * **** ** *****, ******** *********** ********.\u003C**\u003E•\t******* ***** ** *% ****** ***** **** (******** *******)."
          }
        },
        {
          "@type":"Organization",
          "name":"****** ********",
          "member":{
            "@type":"OrganizationRole",
            "description":"•\t******* ******* *** * ********* ********** ********** ** ***** *,***+ ****** ****** ********* ** *** ****** ****** ******* *** **** ***.\u003C**\u003E•\t*********** ****** *** *********** ** ********* ***** ** ****** ******** ****** ** **%, ********** ********* ** ***** ***** ************.\u003C**\u003E•\t************ ** ******** ******** & ********** ****, **** ** ********* ***** ** ********* *** ******* ********** ****** ******** *****.  ********** ********** *** ******* ** ***** ********** ***********, ********* ** * *** ******** ***** ******** ** ** ******."
          }
        },
        {
          "@type":"Organization",
          "name":"****** ********",
          "member":{
            "@type":"OrganizationRole",
            "description":"*********** *** *** ********, **************, *** ****************** ** * ******** ******* ******** ********.   ******** ****** ********* ** ************ ******** (**) ******** ** ******** ****** ** *** ********’* **** ********* ******** ******** ************.  \u003C**\u003E******** **************** *******:\u003C**\u003E•\t***** ** *****, ************* ***+ ********* *** $*** ** *******\u003C**\u003E•\t******* *** *********** ******* **** ******** ********** **** ** ******* ** * **** ****.\u003C**\u003E•\t******* *** ******* ********** ******, ******** ********** ******, *** ******** ********** ******** *****\u003C**\u003E•\t******* ** ** ******** *********** ******** *** **** ** ******* ** ** ************** *** ****** ***********, ********* *******/******** ************ **********\u003C**\u003E•\t***/******** *** ******* ******* ********** \u003C**\u003E\u003C**\u003E*************:\u003C**\u003E•\t******** ******* ******* ****** ** *% *** ******** ******* ****** ** *%.\u003C**\u003E•\t******* ********** ******:  ********* *** ******** ************** ************* ** ******* ******* *********, ******* ********* ******** ************."
          }
        },
        {
          "@type":"Organization",
          "name":"****** ********, ******** ******** *********",
          "location":"Denver, CO",
          "member":{
            "@type":"OrganizationRole",
            "description":"*************:\u003C**\u003E•\t******** ******* ******* ** **% **** **** ****, **** *** ******** **** **% ** *** ****** ****, *** **% ****** ** *** ***** ****.\u003C**\u003E•\t************ ******* &**;$*** ** ******** ******** *** ********** &**;$*** ** ****** *******.\u003C**\u003E•\t************ ******** **** ***** ******** ************ *** *********** ********* *********."
          }
        },
        {
          "@type":"Organization",
          "name":"****** ******** ****",
          "member":{
            "@type":"OrganizationRole"
          }
        },
        {
          "@type":"Organization",
          "name":"******** *********, ******** ******* **",
          "member":{
            "@type":"OrganizationRole"
          }
        },
        {
          "@type":"Organization",
          "name":"******** *********",
          "member":{
            "@type":"OrganizationRole",
            "description":"******* **** ** ******* ******** ************ *** ******** ******* ** ********* ******** *** ********'* ********* ************ *****\u003C**\u003E*************:\u003C**\u003E•\t****** *** ** *** *********** ** ******** *****, *****, ******** ************, ****** *******, *** ***** ******* ******** *** ** *********** ******* ** ******* *******.  ******** ******* ****** ***** *******."
          }
        },
        {
          "@type":"Organization",
          "name":"******** *********",
          "member":{
            "@type":"OrganizationRole",
            "description":"*********** **** *** **** *** ** ********* **** * ********** ***** ****** ** ******** *****, ******* ****** ******* *** ********* ***."
          }
        },
        {
          "@type":"Organization",
          "name":"****** ***********",
          "location":"Denver, CO",
          "member":{
            "@type":"OrganizationRole"
          }
        }
      ],
      "knowsLanguage":[

      ],
      "disambiguatingDescription":"",
      "interactionStatistic":{
        "@type":"InteractionCounter",
        "interactionType":"https://schema.org/FollowAction",
        "name":"Follows",
        "userInteractionCount":3530
      },
      "description":"Highly motivated and driven to personally succeed through coaching and assisting…"
    },
    {
      "@type":"WebPage",
      "url":"https://www.linkedin.com/in/jonwsnow",
      "reviewedBy":{
        "@type":"Person",
        "name":"Jon Snow"
      }
    }
  ]
}
```

##### FB raw data we get during the scrapping

```json
{
   "page_name":"Paul Kirby: Member for Port Darwin",
   "page_category":"Politiker/in",
   "email":"electorate.portdarwin@nt.gov.au",
   "page_website":[
      "http://www.territorylabor.com.au",
      "https://parliament.nt.gov.au/members/by-name/paul-kirby"
   ],
   "social_media_links":[
      "https://www.instagram.com/kirbyportdarwin",
      "https://linkedin.com/in"
   ],
   "phone_number":"None",
   "location":"http://www.territorylabor.com.au/",
   "page_rate":"None",
   "page_review_number":"None",
   "page_likes":"None",
   "page_followers":"3.861 Follower",
   "following":"1,065 followed"

}
```

##### FB our data, saved in the mongoDB

Facebook List of Persons

```json
[
  {
    "id": "970ba0e4-105a-416d-a998-df846e0b9858",
    "firstName": "Anthony",
    "lastName": "Zurcher",
    "email": "haveyoursay@bbc.co.uk",
    "phone": null,
    "profession": "Media/news company",
    "personalWebPageURL": "http://www.bbc.co.uk/news",
    "followers": 48,
    "following": 0,
    "location": "BBC Broadcasting House, London, United Kingdom, W1A 1AA"
  },
  {
    "id": "845d587c-8c5a-409b-9db1-ed1e9c51916b",
    "firstName": "Anthony",
    "lastName": "Zurcher",
    "email": "newsroomznbc@gmail.com",
    "phone": null,
    "profession": "Interest",
    "personalWebPageURL": "https://znbc.co.zm",
    "followers": 982000,
    "following": 0,
    "location": "ZNBC, P.O Box 50015, Mass Media Complex, Alick Nkata Road, Lusaka., 10101"
  },
  {
    "id": "48e7a87d-171b-47bf-853e-94ca5443483d",
    "firstName": "Anthony",
    "lastName": "Zurcher",
    "email": "info@creators.com",
    "phone": "+1 310-337-7003",
    "profession": "Arts & entertainment",
    "personalWebPageURL": "http://www.Creators.com",
    "followers": 2000,
    "following": 0,
    "location": "+1 310-337-7003"
  }
]
```

#### curl example

```bash
 curl -X POST http://localhost:5001 -d "{\"link\":\"https://www.facebook.com/mr.pallab.ghosh/\"}"  -H "Content-Type: application/json"
 ```

#### How to run python, FB page scrapper

Create venv - virtual environment

```bash
python3 -m venv fb_scapper_venv
```

Activate created venv

```bash
source fb_scapper_venv/bin/activate
```

Install all fb_scrapper dependencies

```bash
pip install -r requirements.txt
```

And finally, run a script

```bash
python3 -m fb_page_scrapper <any_port_of_yours>
```

#### How to deploy mkdocs, a documentaion

```
source doc_venv/bin/activate
```

Then run

```
 mkdocs gh-deploy
```

Wait for awhile, and go:

```bash
 https://hob1t.github.io/poirot/
```

#### How to prepare a presentation

**Rule 1**: Include only one idea per slide

**Rule 2:** Spend only 1 minute per slide

**Rule 3:** Make use of your heading

**Rule 4:** Include only essential points

**Rule 5:** Give credit, where credit is due

**Rule 6:** Use graphics effectively

**Rule 7:** Design to avoid cognitive overload

**Rule 8:** Design the slide so that a distracted person gets the main takeaway

**Rule 9:** Iteratively improve slide design through practice

**Rule 10:** Design to mitigate the impact of technical disasters


References:

[Ten simple rules for effective presentation slides](https://journals.plos.org/ploscompbiol/article?id=10.1371/journal.pcbi.1009554)