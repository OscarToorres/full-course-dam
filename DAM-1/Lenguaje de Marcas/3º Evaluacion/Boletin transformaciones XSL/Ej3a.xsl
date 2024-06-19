<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h3>Equipos de: 
                    <xsl:for-each select="equipos_de_futbol">
                        <xsl:value-of select="@pais"/>
                    </xsl:for-each>
                </h3>
                <xsl:for-each select="equipos_de_futbol/equipo">              
                <ul>
                    <li><u><xsl:value-of select="nombre"/></u>, de la ciudad:<br/>
                        <xsl:value-of select="ciudad"/><br/>
                        Jugadores: <xsl:value-of select="jugadores"/>
                    </li>
                </ul>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>