<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <html>
            <body>
                <xsl:for-each select="ies">
                    <h1><p>Ciclos formativos del <xsl:value-of select="nombre"/></p></h1>
                </xsl:for-each>
                <ul>
                    <xsl:for-each select="ies/ciclos/ciclo">
                        <li><xsl:value-of select="@id"/>
                        <br/>
                        <p><xsl:value-of select="nombre"/>, ciclo formativo de grado <xsl:value-of select="grado"/> creado en <xsl:value-of select="decretoTitulo/@año"/></p> 
                        </li>
                </xsl:for-each>
                </ul>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet> 