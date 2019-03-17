#!/bin/bash
cd `dirname $0`
java -Xmx1024M -Xms1024M -Ddsio.dir=./importDSIO -Dnbjours.renouv=14 -Dnbjours.deprenouv=-15 -Dpdf.reader=evince -Ddatabase.file=./orthodonfree.sqlite -Dsql.config=./sql.xml -jar ./OrthodonFree.jar

