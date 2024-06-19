<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h3>     
                    Equipos de: <xsl:value-of select="equipos_de_futbol/@pais"/><br/>   
                </h3> 
                 <table border="1">
                    <tr bgcolor="green">
                        <td>Jugador 1:</td>
                        <td>Jugador 2:</td>
                        <td>Equipo:</td>
                        <td>Ciudad:</td>
                    </tr>
                    <xsl:for-each select="equipos_de_futbol/equipo">
                    <tr>
                        <td>
                            <xsl:value-of select="jugadores/jugador@posicion=[]"/>
                        </td>
                        <td>
                            <xsl:value-of select="jugadores/jugador@posicion=[]"/>
                        </td>                          
                        <td>
                            <xsl:value-of select="nombre"/>
                        </td>
                        <td>
                            <xsl:value-of select="ciudad"/>
                        </td>                                               
                    </tr>
                </table>        
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>