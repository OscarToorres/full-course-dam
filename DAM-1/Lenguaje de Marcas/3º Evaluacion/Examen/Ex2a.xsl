<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <xsl:for-each select="equipos_de_futbol/equipo">
                    <xsl:if test="nombre='Real Sociedad'">
                        <h3>Los jugadores del: <u><xsl:value-of select="nombre"/></u></h3>
                    </xsl:if>
                </xsl:for-each>
                <xsl:for-each select="equipos_de_futbol/equipo">
                <xsl:if test="nombre='Real Sociedad'">
                <ul>
                    <li><xsl:value-of select="jugadores/jugador/nombre"></li>
                </ul>
                </xsl:if>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>