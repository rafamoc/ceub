# Pasta onde estão os arquivos enviados
$folder = "entrega03/_enviados/"

# Arquivo de saída
$outputFile = "entrega03/_enviados/saida_hashes.txt"

# Calcula os hashes de ZIP e RAR, ordena e grava no TXT
Get-ChildItem -Path $folder -File |
Where-Object { $_.Extension -in ".zip", ".rar", ".tar", ".gz" } |
ForEach-Object {
    $hash = Get-FileHash $_.FullName -Algorithm SHA256
    [PSCustomObject]@{
        Hash = $hash.Hash
        File = $_.Name
    }
} |
Sort-Object Hash |
ForEach-Object {
    "$($_.Hash)  $($_.File)"
} |
Out-File -Encoding UTF8 $outputFile

Write-Host "Arquivo gerado em: $outputFile"